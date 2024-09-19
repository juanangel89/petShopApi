package com.petShop.persistance;

import com.petShop.persistance.crud.OwnerCrudRepository;
import com.petShop.persistance.entity.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class OwnerRepository {
    private OwnerCrudRepository ownerCrudRepository;

    public List<Owner> getAll(){
        return (List<Owner>) ownerCrudRepository.findAll();
    }

    public Optional<Owner> getOwnerById(int idOwner){
        return ownerCrudRepository.findById(idOwner);
    }

    public Owner save(Owner owner){
        return ownerCrudRepository.save(owner);
    }

    public void deleted(int idOwner){
        ownerCrudRepository.deleteById(idOwner);
    }

    public boolean existsOwner(int idOwner){
        return ownerCrudRepository.existsById(idOwner);
    }

    public long countAll(){
        return ownerCrudRepository.count();
    }
}
