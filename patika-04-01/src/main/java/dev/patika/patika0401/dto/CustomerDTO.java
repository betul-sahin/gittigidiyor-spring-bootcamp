package dev.patika.patika0401.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO  {
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Koray")
    private String firstName;

    @ApiModelProperty(example = "Güney")
    private String lastName;

    @ApiModelProperty(example = "11111111111")
    private long ssid;

    @ApiModelProperty(example = "patika@dev.com")
    private String email;

}
