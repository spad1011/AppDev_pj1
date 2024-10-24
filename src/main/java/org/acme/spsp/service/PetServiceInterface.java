package org.acme.spsp.service;

import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.Daos.NameBreedTypePet;

import java.util.List;

public interface PetServiceInterface {

     void createPet(Pet pet);
     List<Pet> getAllPets();
     Pet getPetById(int id);
     void deletePet(int id);
     void updatePet(Pet pet);
     void deletePetsByName(String petName);
     List<Pet> getPetsByType(String type);
     List<Pet> getPetsByBreed(String breed);
     List<NameBreedTypePet> getPetsNameBreedType();
     String getPetStatistics();
}
