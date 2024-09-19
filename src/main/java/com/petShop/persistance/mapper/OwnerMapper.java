package com.petShop.persistance.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.petShop.domain.OwnerDomain;
import com.petShop.persistance.entity.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper (componentModel = "spring")
public interface OwnerMapper {
    @Mappings({
            @Mapping(source = "idOwner",target = "idOwner"),
            @Mapping(source = "nameOwner",target = "nameOwner"),
            @Mapping(source = "lastNameOwner",target = "lastNameOwner"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "number",target = "number"),
            @Mapping(source = "address",target = "address")
    })
    OwnerDomain toOwner(Owner owner);
    List<OwnerDomain> toOwners(List<Owner> owners);
}
