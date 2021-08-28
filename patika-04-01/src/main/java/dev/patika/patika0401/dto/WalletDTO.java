package dev.patika.patika0401.dto;

import dev.patika.patika0401.model.AbstractBaseEntity;
import dev.patika.patika0401.model.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO extends AbstractBaseEntity {

    private long id;
    private double balance;
    private Currency currency;
    private LocalDate createDate;



}
