package org.acme.spsp.service;

import org.acme.spsp.entity.Household;
import org.acme.spsp.service.exceptions.BadDataException;
import org.acme.spsp.service.exceptions.NotFoundException;

import java.util.List;


public interface HouseholdService {

    Household findByEircode(String eircode) throws NotFoundException;

    Household findByEircodeWithPets(String eircode);

    List<Household> findAllByPetsEmpty();

    List<Household> findAll();

    void deleteByEircode(String eircode) throws NotFoundException;

    Household createHousehold(Household household) throws BadDataException;
}
