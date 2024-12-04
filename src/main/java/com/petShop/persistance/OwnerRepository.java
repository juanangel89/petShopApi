package com.petShop.persistance;

import com.petShop.domain.dto.OwnerDTO;
import com.petShop.domain.repository.OwnerDomainRepository;
import com.petShop.persistance.crud.OwnerCrudRepository;
import com.petShop.persistance.entity.Owner;
import com.petShop.persistance.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OwnerRepository implements OwnerDomainRepository {

    @Autowired
    private OwnerCrudRepository ownerCrudRepository;

    @Autowired
    private OwnerMapper mapper;
    @Override
    public Iterable<OwnerDTO> getAll() {
        Iterable<Owner> owners = ownerCrudRepository.findAll();
        // Mapeo explícito de cada entidad a DTO
        return ((List<Owner>) owners).stream()
                .map(mapper::toOwnerDTO) // Mapea cada Pet a PetDTO
                .collect(Collectors.toList());
    }
//    public List<Owner> getAll(){
//        return (List<Owner>) ownerCrudRepository.findAll();
//    }
    @Override
    public Optional<OwnerDTO> getOwnerById(int idOwner){
        Optional<Owner> owner = ownerCrudRepository.findById(idOwner);
        return owner.map(mapper::toOwnerDTO);
    }

    // Guardar
    @Override
    public OwnerDTO save(OwnerDTO ownerDTO){
        System.out.println("Datos recibidos en DTO: " + ownerDTO);

        Owner owner = mapper.toEntity(ownerDTO);
        System.out.println("Datos mapeados a la entidad: " + owner);

        Integer ownerId = owner.getIdOwner();

        if (ownerId != null && existsOwner(ownerId)) {
            throw new IllegalArgumentException("El registro ya existe");
        }
        Owner savedOwner = ownerCrudRepository.save(owner);
        System.out.println("Datos guardados en la base de datos: " + savedOwner);
        return mapper.toOwnerDTO(savedOwner);
    }

    // Actualizar
    @Override
    public OwnerDTO update(OwnerDTO ownerDTO){
        System.out.println("Datos recibidos en DTO: " + ownerDTO);

        Owner owner = mapper.toEntity(ownerDTO);
        System.out.println("Datos mapeados a la entidad: " + owner);

        Integer ownerId = owner.getIdOwner();

        if (!existsOwner(ownerId)) {
            throw new IllegalArgumentException("El registro  no existe");
        }
        Owner updateOwner = ownerCrudRepository.save(owner);
        System.out.println("Datos guardados en la base de datos: " + updateOwner);
        return mapper.toOwnerDTO(updateOwner);
    }

    @Override
    public void delete(int idOwner){

        if (existsOwner(idOwner)) {
            ownerCrudRepository.deleteById(idOwner);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }
    @Override
    public boolean existsOwner(int idOwner){
        return ownerCrudRepository.existsById(idOwner);
    }
    @Override
    public long countAll(){
        return ownerCrudRepository.count();
    }

    @Override
    public Optional<List<OwnerDTO>> getByName(String name) {
        return Optional.empty();
    }

}
