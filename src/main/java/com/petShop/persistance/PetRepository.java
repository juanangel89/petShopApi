package com.petShop.persistance;

import com.petShop.domain.dto.PetDTO;
import com.petShop.domain.repository.PetDomainRepository;
import com.petShop.persistance.crud.PetCrudRepository;
import com.petShop.persistance.entity.Pet;
import com.petShop.persistance.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PetRepository implements PetDomainRepository {

    @Autowired
    private PetCrudRepository petCrudRepository;

    @Autowired
    private PetMapper mapper;

    //metodos por default
//    @Override
//    public List<PetDTO> getAll(){
//        List<Pet> pets = (List<Pet>) petCrudRepository.findAll();
//        return mapper.toPetDTOs(pets); //corregido a toPetDTO
//    }
    // Consultar todos los registros
    @Override
    public Iterable<PetDTO> getAll() {
        Iterable<Pet> pets = petCrudRepository.findAll();
        // Mapeo explícito de cada entidad a DTO
        return ((List<Pet>) pets).stream()
                .map(mapper::toPetDTO) // Mapea cada Pet a PetDTO
         .collect(Collectors.toList());
    }

//    @Override
//    public Optional <PetDTO> getPetById(int idPet){
//        return petCrudRepository.findById(idPet).map(Pet -> mapper.toPetDTO(Pet)); //corregido a toPetDTO
//    }

    // Consultar por ID
    @Override
    public Optional<PetDTO> getPetById(int idPet) {
        Optional<Pet> pet = petCrudRepository.findById(idPet);
        return pet.map(mapper::toPetDTO);
    }

//    public PetDTO save(PetDTO petDTO) {
//        Pet pet = mapper.toPet(petDTO);  // Mapeo de PetDTO a Pet
//        Pet savedPet = petCrudRepository.save(pet);  // Guardar en el repositorio
//        return mapper.toPetDTO(savedPet);  // Mapeo de Pet (persistencia) a PetDTO
//    }

    // Guardar
    @Override
    public PetDTO save(PetDTO petDTO) {
        Pet pet = mapper.toEntity(petDTO);
        Integer petId = pet.getIdPet();

        if (petId != null && existsPet(petId)) {
            throw new IllegalArgumentException("El registro ya existe");
        }
        Pet savedPet = petCrudRepository.save(pet);
        return mapper.toPetDTO(savedPet);
    }

    // Actualizar
    @Override
    public PetDTO update(PetDTO petDTO) {
        Pet pet = mapper.toEntity(petDTO);
        Integer petId = pet.getIdPet();

        if (petId == null || !existsPet(petId)) {
            throw new IllegalArgumentException("El registro no existe para actualizar");
        }
        Pet updatedPet = petCrudRepository.save(pet);
        return mapper.toPetDTO(updatedPet);
    }

    // Eliminar
    @Override
    public void delete(int id) {
        if (existsPet(id)) {
            petCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }


//    @Override
//    public void deleted(int idPet){
//        petCrudRepository.deleteById(idPet);
//    }

    // Validar si existe por ID
    @Override
    public boolean existsPet(int idPet){
        return petCrudRepository.existsById(idPet);
    }

    // Contar todos los registros
    @Override
    public long countAll(){
        return petCrudRepository.count();
    }

    @Override
    public Optional<List<PetDTO>> getByName(String name) {
        return Optional.empty();
    }

    //query method
    public List<Pet> getBySpecies (String species){
        return petCrudRepository.findBySpeciesOrderByNamePetAsc(species);
    }

    public List<Pet> findPetsBySpecies(String species) {
        return petCrudRepository.findPetsBySpecies(species);
    }

}
