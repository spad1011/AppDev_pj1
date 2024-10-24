package org.acme.spsp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pets")
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String animalType;

    @NotNull
    private String breed;

    @Min(0)
    @NotNull
    private int age;

    @ManyToOne(optional = false)
    @JoinColumn(name = "household_fk", nullable = false)
    private Household household;

}
