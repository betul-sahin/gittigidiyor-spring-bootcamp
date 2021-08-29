package dev.patika.patika0401.dto;

import dev.patika.patika0401.model.AbstractBaseEntity;
import dev.patika.patika0401.model.enumeration.Currency;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO extends AbstractBaseEntity {

    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "0.0")
    private double balance;

    @ApiModelProperty(example = "TRY or USD or EUR or GBP")
    private Currency currency;

    private int customerId;


}
