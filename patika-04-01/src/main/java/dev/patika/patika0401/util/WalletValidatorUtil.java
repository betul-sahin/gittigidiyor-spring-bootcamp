package dev.patika.patika0401.util;

import dev.patika.patika0401.exceptions.BadRequestException;

public class WalletValidatorUtil {


    public static void validateWalletBalance(double balance) {
        if(balance < 0){
            throw new BadRequestException(ErrorMessageConstants.BALANCE_IS_MINUS);
        }
    }
}
