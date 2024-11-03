package org.acme.spsp.controller;

import lombok.AllArgsConstructor;
import org.acme.spsp.entity.Household;
import org.acme.spsp.service.HouseholdService;
import org.acme.spsp.service.PetService;
import org.acme.spsp.service.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("myapi/households")
public class HouseholdController {
    private final HouseholdService householdService;
    private final PetService petService;

    @GetMapping({"", "/"})
    public List<Household> getAllHouseholds() {
        return householdService.findAll();
    }

    @GetMapping({"/no-pets"})
    public List<Household> getAllNoPets() {
        return householdService.findAllByPetsEmpty();
    }

    @GetMapping({"/{eircode}"})
    public Household getHouseholdWithPets(@PathVariable String eircode) {
        return householdService.findByEircodeWithPets(eircode);
    }

    @DeleteMapping({"/{eircode}"})
    public void deleteHousehold(@PathVariable String eircode) throws NotFoundException {
        householdService.deleteByEircode(eircode);
    }

}
