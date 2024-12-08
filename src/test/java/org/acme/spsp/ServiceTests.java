package org.acme.spsp;


import org.acme.spsp.entity.Household;
import org.acme.spsp.entity.Pet;
import org.acme.spsp.repositiory.HouseholdRepository;
import org.acme.spsp.repositiory.PetRepository;
import org.acme.spsp.service.HouseholdService;
import org.acme.spsp.service.HouseholdServiceImpl;
import org.acme.spsp.service.PetService;
import org.acme.spsp.service.PetServiceImpl;
import org.acme.spsp.service.exceptions.BadDataException;
import org.acme.spsp.service.exceptions.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WithMockUser("ADMIN")
public class ServiceTests {
    private final HouseholdRepository householdRepository = mock(HouseholdRepository.class);
    private final HouseholdService householdService = new HouseholdServiceImpl(householdRepository);
    private final PetRepository petRepository = mock(PetRepository.class);
    private final PetService petService = new PetServiceImpl(petRepository);

    @Test
    void shouldCreateHousehold() {
        Household household = new Household("A12345", 3, 5, true);
        when(householdRepository.save(household)).thenReturn(household);
        assertEquals(household, householdService.createHousehold(household));
        verify(householdRepository, times(1)).save(household);
    }

    @Test
    void shouldThrowBadDataException() {
        Pet pet = new Pet("Nibbles", "Dog", "German Dog", 1, null);
        BadDataException badDataException =assertThrows(BadDataException.class, () -> petService.createPet(pet));
        assertEquals("A pet has to have a Household.", badDataException.getMessage());
        verify(petRepository, never()).save(any());
    }

    @Test
    void shouldThrowNotFoundException() {
        String eircode = "A98765";
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> householdService.findByEircode(eircode));
        assertEquals("Household with eircode "  + eircode +  " not found", notFoundException.getMessage());
    }
}
