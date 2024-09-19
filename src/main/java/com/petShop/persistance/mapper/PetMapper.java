package com.petShop.persistance.mapper;

import com.petShop.domain.PetDomain;
import com.petShop.persistance.entity.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OwnerMapper.class})
public interface PetMapper {
    @Mappings({
            @Mapping(source = "idMascota",target = "idPet"),
            @Mapping(source = "mascota",target = "namePet"),
            @Mapping(source = "especie",target = "species"),
            @Mapping(source = "edad",target = "age"),
            @Mapping(source = "genero",target = "gender"),
            @Mapping(source = "propietario",target = "owner")
    })
    PetDomain toPet(Pet pet);
    List<PetDomain> toPets(List<Pet> pets);

}
