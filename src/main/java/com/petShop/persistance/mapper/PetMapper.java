package com.petShop.persistance.mapper;

import com.petShop.domain.dto.PetDTO;
import com.petShop.persistance.entity.Owner;
import com.petShop.persistance.entity.Pet;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OwnerMapper.class})
public interface PetMapper {
    @Mappings({
            @Mapping(source = "idPet", target = "idMascota"),
            @Mapping(source = "namePet", target = "mascota"),
            @Mapping(source = "species", target = "especie"),
            @Mapping(source = "age", target = "edad"),
            @Mapping(source = "gender", target = "genero"),
            @Mapping(source = "owner.idOwner", target = "propietarioDominio") // Relación con OwnerMapper
    })
    PetDTO toPetDTO(Pet pet);

    @InheritInverseConfiguration
    @Mapping(target = "owner", ignore = true) // Requiere un método explícito
    Pet toEntity(PetDTO petDTO);

    // Método explícito para convertir Integer (ID del propietario) a Owner
//    default Owner map(Integer idOwner) {
//        if (idOwner != null) {
//            Owner owner = new Owner();
//            owner.setIdOwner(idOwner);
//            return owner;
//        }
//        return null;
//    }
    // Métodos para listas
    List<PetDTO> toPetDTOs(List<Pet> pets);
    List<Pet> toPets(List<PetDTO> petDTOs);
}
