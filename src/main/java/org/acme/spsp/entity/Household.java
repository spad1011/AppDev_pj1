package org.acme.spsp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Household {

    public static final String EIRCODE_PATTERN = ".*";

    @Pattern(regexp = EIRCODE_PATTERN)
    @Id
    String eircode;

    @NotNull
    int numberOfOccupants;

    @NotNull
    int maxNumberOfOccupants;

    @NotNull
    boolean ownerOccupied;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Pet> pets;

    public Household(String eircode, int numberOfOccupants, int maxNumberOfOccupants, boolean ownerOccupied) {
        this.eircode = eircode;
        this.numberOfOccupants = numberOfOccupants;
        this.maxNumberOfOccupants = maxNumberOfOccupants;
        this.ownerOccupied = ownerOccupied;
    }
}
