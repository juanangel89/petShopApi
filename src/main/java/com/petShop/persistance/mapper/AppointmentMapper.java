package com.petShop.persistance.mapper;

import com.petShop.domain.dto.AppointmentDTO;
import com.petShop.persistance.entity.Appointment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mappings({
            @Mapping(source = "idAppointment", target = "idCita"),
            @Mapping(source = "pet.idPet", target = "mascotaDominio"),
            @Mapping(source = "employee.idEmployee", target = "empleadoDominio"),
            @Mapping(source = "description", target = "descripcion"),
            @Mapping(source = "date", target = "fecha")
    })
    AppointmentDTO toAppointmentDTO(Appointment appointment);

    List<AppointmentDTO> toAppointmentDTOs(List<Appointment> appointments);

    @InheritInverseConfiguration
    Appointment toEntity(AppointmentDTO appointmentDTO);
}