package com.petShop.domain.repository;

import com.petShop.domain.dto.AppointmentDTO;

import java.util.Optional;

public interface AppointmentDomainRepository {
    Iterable<AppointmentDTO> getAll();
    Optional<AppointmentDTO> getAppointmentById(int idAppointment);
    AppointmentDTO save(AppointmentDTO appointmentDTO);
    AppointmentDTO update(AppointmentDTO appointmentDTO);
    void delete(int idAppointment);
    boolean existsAppointment(int idAppointment);
    long countAll();
}
