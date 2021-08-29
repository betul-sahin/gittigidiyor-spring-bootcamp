package dev.patika.patika0401.controller;

import dev.patika.patika0401.dto.WalletDTO;
import dev.patika.patika0401.model.Wallet;
import dev.patika.patika0401.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/save-wallet")
    public ResponseEntity<Wallet> saveWallet(@RequestBody @Valid WalletDTO walletDTO) {

        Optional<Wallet> resultOptional = walletService.save_wallet(walletDTO);

        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/deposit/{customerId}/{currency}/{amount}")
    public ResponseEntity<Wallet> depositToWallet(@PathVariable long customerId,
                                                  @PathVariable("currency") String currencyName,
                                                  @PathVariable double amount) {
        Optional<Wallet> resultOptional = walletService.deposit(customerId, currencyName, amount);

        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/withdraw/{customerId}/{currency}/{amount}")
    public ResponseEntity<Wallet> withdrawFromWallet(@PathVariable long customerId,
                                                  @PathVariable("currency") String currencyName,
                                                  @PathVariable double amount) {
        Optional<Wallet> resultOptional = walletService.withdraw(customerId, currencyName, amount);

        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    /*
        Write an endpoint to get all wallets from DB (use customer id with requestparam
        and if customer id is not exist, get all wallets with same endpoint)
     */

}
