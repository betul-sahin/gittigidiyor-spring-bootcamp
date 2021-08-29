package dev.patika.patika0401.mappers;

import dev.patika.patika0401.dto.WalletDTO;
import dev.patika.patika0401.model.Wallet;
import org.mapstruct.Mapper;

@Mapper
public interface WalletMapper {

    Wallet mapFromWalletDTOtoWallet(WalletDTO walletDTO);
    WalletDTO mapFromWallettoWalletDTO(Wallet wallet);

}
