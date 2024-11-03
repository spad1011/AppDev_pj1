package org.acme.spsp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
public class Household {

    public static final String EIRCODE_PATTERN = "[ACDEFHKNPRTVWXY]\\d[0-9W][ \\-]?[0-9ACDEFHKNPRTVWXY]{4}/";

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
    @JsonManagedReference
    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pet> pets;

}
