package org.acme.spsp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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
    @JsonBackReference
    @JoinColumn(name = "household_fk", nullable = false)
    Household household;

    public Pet(@NotEmpty @NotNull String name,
               @NotNull String animalType,
               @NotNull String breed,
               @Min(0) @NotNull int age,
               Household household) {
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.household = household;
    }
}
