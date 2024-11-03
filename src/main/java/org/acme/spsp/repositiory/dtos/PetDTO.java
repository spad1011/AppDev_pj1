package org.acme.spsp.repositiory.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static org.acme.spsp.entity.Household.EIRCODE_PATTERN;

public record PetDTO(@NotEmpty @NotNull String name,
                     @NotNull String animalType,
                     @NotNull String breed,
                     @Min(0) @NotNull int age,
                     @NotNull @Pattern(regexp = EIRCODE_PATTERN)String householdEircode) {
}
