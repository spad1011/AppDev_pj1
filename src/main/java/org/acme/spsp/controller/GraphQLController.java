package org.acme.spsp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.acme.spsp.entity.Household;
import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.dtos.HouseholdDTO;
import org.acme.spsp.repositiory.dtos.PetDTO;
import org.acme.spsp.service.HouseholdService;
import org.acme.spsp.service.PetService;
import org.acme.spsp.service.exceptions.NotFoundException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLController {
    private PetService petService;
    private HouseholdService householdService;

    @QueryMapping
    Pet petById(@Argument("petId") int petId) throws NotFoundException {
        return petService.findPetById(petId);
    }

    @QueryMapping
    List<Pet> findAllPets() {
        return petService.findAllPets();
    }

    @QueryMapping
    List<Pet> findAllPetsByType(@Argument("type") String type) {
        return petService.getPetsByType(type);
    }

    @QueryMapping
    Household householdByEircode(@Argument("eircode") String eircode) throws NotFoundException {
        return householdService.findByEircode(eircode);
    }

    @QueryMapping
    String petStatistics() {
        return petService.getPetStatistics();
    }

    @Secured(value = "ROLE_ADMIN")
    @MutationMapping
    int deletePet(@Argument("petId") int id) {
        petService.deletePet(id);
        return 1;
    }

    @Secured(value = "ROLE_ADMIN")
    @MutationMapping
    Pet createPet(@Valid @Argument("pet") PetDTO petDTO) throws NotFoundException {
        Household household = null;
        String houseHoldEircode = petDTO.householdEircode();
        if (houseHoldEircode != null && !houseHoldEircode.isEmpty())
            household = householdService.findByEircode(houseHoldEircode);
        Pet pet = new Pet(petDTO.name(), petDTO.animalType(), petDTO.breed(), petDTO.age(), household);
        return petService.createPet(pet);
    }

    @Secured(value = "ROLE_ADMIN")
    @MutationMapping
    String deleteHousehold(@Argument("eircode") String eircode) throws NotFoundException {
        householdService.deleteByEircode(eircode);
        return "Deleted";
    }

    @Secured(value = "ROLE_ADMIN")
    @MutationMapping
    Household createHousehold( @Argument("household") HouseholdDTO householdDTO) {
        Household household = new Household(householdDTO.eircode(), householdDTO.numberOfOccupants(),
                householdDTO.maxNumberOfOccupants(), householdDTO.ownerOccupied());
        return householdService.createHousehold(household);
    }

}
