package dev.patika.patika0401.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends AbstractBaseEntity {

    private String firstName;
    private String lastName;
    private long ssid;
    private String email;

}
