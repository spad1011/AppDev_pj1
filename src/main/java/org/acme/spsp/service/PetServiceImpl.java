package org.acme.spsp.service;

import lombok.extern.slf4j.Slf4j;
import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.Daos.NameBreedTypePet;
import org.acme.spsp.repositiory.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PetServiceImpl implements PetServiceInterface {
    private PetRepository petRepository;

    @Override
    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(int id) {
        return petRepository.getReferenceById(id);
    }

    @Override
    public void deletePet(int id) {
        petRepository.deletePetById(id);
    }

    @Override
    public void updatePet(Pet pet) {
        if (petRepository.getReferenceById(pet.getId()) == null) {
            log.error("Pet with id {} not found", pet.getId());
        } else {
            petRepository.save(pet);
        }
    }

    @Override
    public void deletePetsByName(String petName) {
        List<Pet> pets = petRepository.findAll();
        pets.stream().filter(pet -> pet.getName().equals(petName)).forEach(petRepository::delete);
        petRepository.deleteAllByName(petName);
    }

    @Override
    public List<Pet> getPetsByType(String type) {
        return petRepository.findAllByAnimalType(type);
    }

    @Override
    public List<Pet> getPetsByBreed(String breed) {
        return petRepository.findAllByBreed(breed);
    }

    @Override
    public List<NameBreedTypePet> getPetsNameBreedType() {
        return petRepository.findAllBreedTypePet();
    }

    @Override
    public String getPetStatistics() {
        List<Pet> pets = petRepository.findAll();
        int count = pets.size();
        int maxAge = petRepository.findMaxAge();

        return "";
    }
}
