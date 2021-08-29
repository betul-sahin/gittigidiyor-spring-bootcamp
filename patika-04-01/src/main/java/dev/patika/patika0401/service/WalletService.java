package dev.patika.patika0401.service;

import dev.patika.patika0401.dto.WalletDTO;
import dev.patika.patika0401.exceptions.BadRequestException;
import dev.patika.patika0401.exceptions.CustomerNotFoundException;
import dev.patika.patika0401.exceptions.NoEnoughBalanceForWithdrawException;
import dev.patika.patika0401.exceptions.WalletAlreadyExistsException;
import dev.patika.patika0401.mappers.WalletMapper;
import dev.patika.patika0401.model.Customer;
import dev.patika.patika0401.model.Wallet;
import dev.patika.patika0401.model.enumeration.Currency;
import dev.patika.patika0401.repository.CustomerRepository;
import dev.patika.patika0401.repository.WalletRepository;
import dev.patika.patika0401.util.ErrorMessageConstants;
import dev.patika.patika0401.util.WalletValidatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional
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

    @Transactional
    public Optional<Wallet> deposit(long customerId, String currencyName, double amount) {
        Optional<Wallet> wallet = getWallet(customerId, currencyName);
        wallet.get().setBalance(wallet.get().getBalance() + amount);
        walletRepository.save(wallet.get());
        return wallet;
    }

    @Transactional
    public Optional<Wallet> withdraw(long customerId, String currencyName, double amount) {
        Optional<Wallet> wallet = getWallet(customerId, currencyName);
        if(amount > wallet.get().getBalance()){
            throw new NoEnoughBalanceForWithdrawException(ErrorMessageConstants.No_ENOUGH_BALANCE + amount + " " +
                    wallet.get().getCurrency().getCurrencySign());
        }
        wallet.get().setBalance(wallet.get().getBalance() - amount);
        walletRepository.save(wallet.get());
        return wallet;
    }

    private Optional<Wallet> getWallet(long customerId, String currencyName) {
        Customer customer = this.findCustomerById(customerId);
        Optional<Wallet> wallet = customer.getWallets().stream().filter(w -> w.getCurrency().equals(Currency.valueOf(currencyName))).findFirst();
        if(!wallet.isPresent()){
            throw new BadRequestException("Customer : " + customer.getFirstName()+ " " + customer.getLastName() + " does not have wallet with "
            + currencyName);
        }
        return wallet;
    }


    public Optional<List<Wallet>> getWallets(int customerId) {
        Customer customer = this.findCustomerById(customerId);
        Optional<List<Wallet>> wallets = Optional.of(customer.getWallets());

        if (wallets.get().isEmpty()) {
            wallets = Optional.of(walletRepository.findAll());
        }

        return wallets;
    }
}
