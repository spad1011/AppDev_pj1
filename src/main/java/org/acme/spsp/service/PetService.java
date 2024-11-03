package org.acme.spsp.service;

import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.dtos.NameBreedTypePet;
import org.acme.spsp.service.exceptions.BadDataException;
import org.acme.spsp.service.exceptions.NotFoundException;

import java.util.List;

public interface PetService {

     Pet createPet(Pet pet) throws BadDataException;
     List<Pet> findAllPets();
     Pet findPetById(int id) throws NotFoundException;
     void deletePet(int id);
     void updatePet(Pet pet) throws NotFoundException;
     void deletePetsByName(String petName);
     List<Pet> getPetsByType(String type);
     List<Pet> getPetsByBreed(String breed);
     List<NameBreedTypePet> getPetsNameBreedType();
     String getPetStatistics();
}
