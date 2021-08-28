package dev.patika.patika0401.model;

import dev.patika.patika0401.model.enumeration.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wallet")
public class Wallet extends AbstractBaseEntity {

    private double balance;
    private Currency currency;
    private LocalDate createDate;



}
