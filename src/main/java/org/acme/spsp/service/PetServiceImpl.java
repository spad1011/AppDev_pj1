package org.acme.spsp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.dtos.NameBreedTypePet;
import org.acme.spsp.repositiory.PetRepository;
import org.acme.spsp.service.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PetServiceImpl implements PetService {
    private PetRepository petRepository;

    @Override
    public Pet createPet(Pet pet) {

        return petRepository.save(pet);
    }

    @Override
    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet findPetById(int id) throws NotFoundException {
        return petRepository.findById(id).orElseThrow(() -> new NotFoundException("Pet with ID " + id + " not found"));
    }

    @Override
    public void deletePet(int id) {
        petRepository.deleteById(id);
    }

    @Override
    public void updatePet(Pet pet) throws NotFoundException {
        if(!petRepository.existsById(pet.getId())) {
            throw new NotFoundException("Could not update! Pet with ID " + pet.getId() + " not found");
        }
        petRepository.save(pet);
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
        //todo finish this
        return "";
    }
}
