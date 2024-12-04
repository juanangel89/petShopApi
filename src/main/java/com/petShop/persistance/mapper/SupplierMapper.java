package com.petShop.persistance.mapper;

import com.petShop.domain.dto.SupplierDTO;
import com.petShop.persistance.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
@Mapper(componentModel = "spring")
public interface SupplierMapper {

    @Mappings({
            @Mapping(source = "idSupplier", target = "idProveedor"),
            @Mapping(source = "nameSupplier", target = "nombre"),
            @Mapping(source = "email", target = "correo"),
            @Mapping(source = "number", target = "telefono")
    })
    SupplierDTO toSupplierDTO(Supplier supplier);

    @Mappings({
            @Mapping(source = "idProveedor", target = "idSupplier"),
            @Mapping(source = "nombre", target = "nameSupplier"),
            @Mapping(source = "correo", target = "email"),
            @Mapping(source = "telefono", target = "number")
    })
    Supplier toEntity(SupplierDTO supplierDTO);
}