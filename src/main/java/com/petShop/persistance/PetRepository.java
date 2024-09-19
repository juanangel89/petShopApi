package com.petShop.persistance;

import com.petShop.domain.PetDomain;
import com.petShop.domain.repository.PetDomainRepository;
import com.petShop.persistance.crud.PetCrudRepository;
import com.petShop.persistance.entity.Pet;
import com.petShop.persistance.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class PetRepository implements PetDomainRepository {

    @Autowired
    private PetCrudRepository petCrudRepository;

    @Autowired
    private PetMapper mapper;

    //metodos por default
    @Override
    public List<PetDomain> getAll(){
        List<Pet> pets = (List<Pet>) petCrudRepository.findAll();
        return mapper.toPets(pets);
    }

    @Override
    public Optional <PetDomain> getPetById(int idPet){
        return petCrudRepository.findById(idPet).map(Pet -> mapper.toPet(Pet));
    }
    @Override
    public PetDomain save(PetDomain petDomain){
        Pet pet = mapper.toPet(petDomain);
        return mapper.toPet(petCrudRepository.save(pet));
    }
    @Override
    public void deleted(int idPet){
        petCrudRepository.deleteById(idPet);
    }

    public boolean existsPet(int idPet){
        return petCrudRepository.existsById(idPet);
    }

    public long countAll(){
        return petCrudRepository.count();
    }

//query method
    public List<Pet> getBySpecies (String species){
        return petCrudRepository.findBySpeciesOrderByNameAsc(species);
    }

    public List<Pet> findPetsBySpecies(String species) {
        return petCrudRepository.findPetsBySpecies(species);
    }

}
