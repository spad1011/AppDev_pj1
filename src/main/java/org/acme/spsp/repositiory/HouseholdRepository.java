package org.acme.spsp.repositiory;

import org.acme.spsp.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, String> {

    @Query("SELECT h FROM Household h LEFT JOIN FETCH h.pets WHERE h.eircode = :eircode")
    Household findByEircodeWithPets(String eircode);

    @Query("SELECT h from Household h WHERE h.pets IS EMPTY")
    List<Household> findAllByPetsEmpty();
}
