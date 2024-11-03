package org.acme.spsp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.acme.spsp.entity.Household;
import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.dtos.PetDTO;
import org.acme.spsp.service.HouseholdService;
import org.acme.spsp.service.PetService;
import org.acme.spsp.service.exceptions.BadDataException;
import org.acme.spsp.service.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/myapi/pets")
public class PetController {
    private PetService petService;
    private HouseholdService householdService;

    @GetMapping({"", "/"})
    public List<Pet> getAllPets() {
        return petService.findAllPets();
    }

    @GetMapping({"/{id}"})
    public Pet getPetById(@PathVariable("id") int id) throws NotFoundException {
        return petService.findPetById(id);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePetById(@PathVariable("id") int id) {
        petService.deletePet(id);
    }

    @PostMapping({"/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Pet addPet(@RequestBody @Valid PetDTO petDTO) throws NotFoundException, BadDataException {
        Household household = null;
        if(petDTO.householdEircode() != null && !petDTO.householdEircode().isEmpty()) {
            household = householdService.findByEircode(petDTO.householdEircode());
        }
        Pet pet = new Pet(petDTO.name(), petDTO.animalType(), petDTO.breed(), petDTO.age(), household);
        return petService.createPet(pet);
    }

}
