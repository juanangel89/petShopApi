package com.petShop.web.controller;

import com.petShop.domain.dto.PetDTO;
import com.petShop.domain.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/getAll")
    public Iterable<PetDTO> getAll() {
        return petService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<PetDTO> getPetById(@PathVariable("id") int id) {
        return petService.getPetById(id);
    }

    @PostMapping("/save")
    public PetDTO save(@RequestBody PetDTO petDTO) {
        return petService.save(petDTO);
    }

    @PostMapping("/update")
    public PetDTO update(@RequestBody PetDTO petDTO) {
        return petService.update(petDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        petService.delete(id);
    }

    @GetMapping("/existsPet/{id}")
    public boolean existsPet(@PathVariable("id") int id) {
        return petService.existsPet(id);
    }

    @GetMapping("/countPets")
    public long countPets() {
        return petService.countAll();
    }

//    @GetMapping("/getBySpecies/{species}")
//    public List<PetDTO> getBySpecies(@PathVariable("species") String species) {
//        return petService.getBySpecies(species);
//    }


}
