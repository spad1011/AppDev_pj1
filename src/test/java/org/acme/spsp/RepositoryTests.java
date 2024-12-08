package org.acme.spsp;

import org.acme.spsp.entity.Household;
import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.HouseholdRepository;
import org.acme.spsp.repositiory.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@WithMockUser("ADMIN")
@DataJpaTest
class RepositoryTests {

    @Autowired
    HouseholdRepository householdRepository;

    @Autowired
    PetRepository petRepository;

    @BeforeEach
    void setUp() {
        Household household = new Household("A12345", 3, 5, true);
        householdRepository.save(household);

        Pet pet = new Pet("Nibblez", "Hamster", "German Hamster", 1, household);
        petRepository.save(pet);
    }

    @Test
    void shouldFindAllHouseholds(){
        List<Household> households = householdRepository.findAll();

        assertNotNull(households);
        assertThat(households).size().isPositive();
        assertThat(households.getLast().getEircode()).isEqualTo("A12345");
    }

    @Test
    void shouldFindNibblez() {
        List<Pet> pets = petRepository.findAllByAnimalType("Hamster");

        assertThat(pets).hasSize(2);
        assertThat(pets.getLast().getName()).isEqualTo("Nibblez");
    }



}
