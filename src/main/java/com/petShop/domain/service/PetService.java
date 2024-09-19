package com.petShop.domain.service;


import com.petShop.domain.PetDomain;
import com.petShop.domain.repository.PetDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetDomainRepository petDomainRepository;

    public List<PetDomain> getAll() {
        return petDomainRepository.getAll();
    }

    public  Optional<PetDomain> getPetById(int id) {
        return petDomainRepository.getPetById( id);
    }

    public Optional<List<PetDomain>> getByName(String name) {
        return petDomainRepository.getByName(name);
    }

    public boolean deleted(int id){

        return getPet(id).map(pet -> {
            petRepository.delete(id);
            return true;
        }).orElse(false);

    }

    public PetDomain save(PetDomain petDomain) {
        return petDomainRepository.save(petDomain);
    }
}
