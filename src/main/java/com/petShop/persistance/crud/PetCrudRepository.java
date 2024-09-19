package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetCrudRepository extends CrudRepository<Pet,Integer> {
    List<Pet> findBySpeciesOrderByNameAsc(String species);

    @Query(value = "SELECT * FROM mascotas WHERE especies= :species ORDER BY nombre ASC",nativeQuery = true)
    List<Pet> findPetsBySpecies(@Param("species")String species);
}
