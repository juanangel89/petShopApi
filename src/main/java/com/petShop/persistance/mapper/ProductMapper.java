package com.petShop.persistance.mapper;

import com.petShop.domain.dto.ProductDTO;
import com.petShop.persistance.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "idProducto"),
            @Mapping(source = "nameProduct", target = "nombre"),
            @Mapping(source = "description", target = "descripcion"),
            @Mapping(source = "stock", target = "existencias"),
            @Mapping(source = "price", target = "precio"),
            @Mapping(source = "supplier.idSupplier", target = "proveedorDominio")
    })
    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    @InheritInverseConfiguration
    Product toEntity(ProductDTO productDTO);
}
