package org.acme.spsp.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.spsp.entity.Household;
import org.acme.spsp.repositiory.HouseholdRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class HouseholdServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;

    @Override
    public Household findByEircode(String eircode) {
        log.info("findByEircode {}", eircode);
        Optional<Household> household = householdRepository.findById(eircode);
        log.info("findByEircode: Found Household {}", household);
        return household.orElseThrow(() -> new NotFoundException("Household not found"));
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
}
