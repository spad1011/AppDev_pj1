package org.acme.spsp.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.acme.spsp.entity.Household;
import org.acme.spsp.repositiory.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface HouseholdService {

    Household findByEircode(String eircode);

    Household findByEircodeWithPets(String eircode);

    List<Household> findAllByPetsEmpty();
}
