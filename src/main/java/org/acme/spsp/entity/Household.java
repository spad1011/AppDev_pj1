package org.acme.spsp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
public class Household {

    public static final String EIRCODE_PATTERN = "/^([AC-FHKNPRTV-Y]{1}[0-9]{2}|D6W)[ ]?[0-9AC-FHKNPRTV-Y]{4}$/mgi";

    @Pattern(regexp = EIRCODE_PATTERN)
    @Id
    String eircode;

    @NotNull
    Integer numberOfOccupants;

    @NotNull
    Integer maxNumberOfOccupants;

    @NotNull
    Boolean ownerOccupied;

    @ToString.Exclude
    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pet> pets;

}
