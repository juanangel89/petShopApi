package com.petShop.persistance.mapper;

import com.petShop.domain.dto.BillDetailDTO;
import com.petShop.persistance.entity.BillDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BillDetailMapper {

    @Mappings({
            @Mapping(source = "idBillDetail", target = "idFacturaDetalle"),
            @Mapping(source = "appointment.idAppointment", target = "idCita"), // Manejo de la relación con cita
            @Mapping(source = "product.idProduct", target = "idProducto"),    // Manejo de la relación con producto
            @Mapping(source = "quantity", target = "cantidad"),
            @Mapping(source = "date", target = "fecha"),
            @Mapping(source = "price", target = "precio")
    })
    BillDetailDTO toBillDetailDTO(BillDetail billDetail);

    @Mappings({
            @Mapping(source = "idFacturaDetalle", target = "idBillDetail"),
            @Mapping(target = "appointment.idAppointment", source = "idCita"), // Si idCita es null, appointment será null
            @Mapping(target = "product.idProduct", source = "idProducto"),    // Si idProducto es null, product será null
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "precio", target = "price")
    })
    BillDetail toEntity(BillDetailDTO billDetailDTO);
}