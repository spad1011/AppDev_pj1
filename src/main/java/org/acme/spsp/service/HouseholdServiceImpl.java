package org.acme.spsp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.spsp.entity.Household;
import org.acme.spsp.repositiory.HouseholdRepository;
import org.acme.spsp.service.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class HouseholdServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;

    @Override
    public Household findByEircode(String eircode) throws NotFoundException {
        log.info("findByEircode {}", eircode);
        Optional<Household> household = householdRepository.findById(eircode);
        log.info("findByEircode: Found Household {}", household);
        return household.orElseThrow(() -> new NotFoundException("Household with eircode " + eircode + " not found"));
    }

    @Override
    public Household findByEircodeWithPets(String eircode) {
        return householdRepository.findByEircodeWithPets(eircode);
    }

    @Override
    public List<Household> findAllByPetsEmpty() {
        List<Household> households = householdRepository.findAllByPetsEmpty();
        log.info("findAllByPetsEmpty: Found {} Households", households.size());
        return households;
    }

    @Override
    public List<Household> findAll() {
        return householdRepository.findAll();
    }

    @Override
    public void deleteByEircode(String eircode) throws NotFoundException {
        log.info("deleteByEircode {}", eircode);
        if (!householdRepository.existsById(eircode)) {
            throw new NotFoundException("Household with EIERCODE " + eircode + "nicht gefunden");
        }
        householdRepository.deleteById(eircode);
    }

    @Override
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }
}
