package dev.patika.patika0601.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @SequenceGenerator(sequenceName = "employee_sequence", name = "employee_sequence", allocationSize = 1, initialValue = 51)
    @GeneratedValue(generator = "employee_sequence",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
