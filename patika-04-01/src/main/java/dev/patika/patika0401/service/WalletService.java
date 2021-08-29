package dev.patika.patika0401.service;

import dev.patika.patika0401.dto.WalletDTO;
import dev.patika.patika0401.exceptions.CustomerNotFoundException;
import dev.patika.patika0401.exceptions.WalletAlreadyExistsException;
import dev.patika.patika0401.mappers.WalletMapper;
import dev.patika.patika0401.model.Customer;
import dev.patika.patika0401.model.Wallet;
import dev.patika.patika0401.repository.CustomerRepository;
import dev.patika.patika0401.repository.WalletRepository;
import dev.patika.patika0401.util.WalletValidatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WalletMapper walletMapper;

    public Optional<Wallet> save_wallet(WalletDTO walletDTO) {
        this.validateRequest(walletDTO);
        Wallet wallet = walletMapper.mapFromWalletDTOtoWallet(walletDTO);
        if(walletRepository.selectExistsWalletWithSameCurrency(wallet.getCurrency(), wallet.getCustomer().getId())){
            throw new WalletAlreadyExistsException("Wallet with currency type : " + wallet.getCurrency().getCurrencyName()
            + " is already exists!");
        }
        return Optional.of(walletRepository.save(wallet));
    }

    private void validateRequest(WalletDTO walletDTO) {
        WalletValidatorUtil.validateWalletBalance(walletDTO.getBalance());
    }

    public Customer findCustomerById(long customerId){
        Customer foundCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with ID: %d could not foud!", customerId)));
        return foundCustomer;
    }
}
