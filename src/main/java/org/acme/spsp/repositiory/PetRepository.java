package org.acme.spsp.repositiory;

import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.dtos.NameBreedTypePet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findAllByAnimalType(String type);

    @Transactional
    @Modifying
    void deleteAllByName(String name);

    List<Pet> findAllByBreed(String breed);

    @Query("SELECT new org.acme.spsp.repositiory.dtos.NameBreedTypePet(p.name, p.breed, p.animalType) FROM Pet p")
    List<NameBreedTypePet> findAllBreedTypePet();

    @Query("SELECT MAX(age) FROM Pet")
    int findMaxAge();


}
