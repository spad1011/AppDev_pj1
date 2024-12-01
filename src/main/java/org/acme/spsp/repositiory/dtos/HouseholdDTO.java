package org.acme.spsp.repositiory.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static org.acme.spsp.entity.Household.EIRCODE_PATTERN;

public record HouseholdDTO(@Pattern(regexp = EIRCODE_PATTERN) String eircode, @NotNull int numberOfOccupants,
                           @NotNull int maxNumberOfOccupants, @NotNull Boolean ownerOccupied) {
}
