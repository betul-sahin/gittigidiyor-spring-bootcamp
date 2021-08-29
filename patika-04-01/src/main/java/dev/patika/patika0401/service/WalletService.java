package dev.patika.patika0401.service;

import dev.patika.patika0401.dto.WalletDTO;
import dev.patika.patika0401.mappers.WalletMapper;
import dev.patika.patika0401.model.Wallet;
import dev.patika.patika0401.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    public Optional<Wallet> save_wallet(WalletDTO walletDTO) {

        Wallet wallet = walletMapper.mapFromWalletDTOtoWallet(walletDTO);
        return Optional.of(walletRepository.save(wallet));
    }
}
