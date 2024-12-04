package com.petShop.persistance;

import com.petShop.domain.dto.AppointmentDTO;
import com.petShop.domain.repository.AppointmentDomainRepository;
import com.petShop.persistance.crud.AppointmentCrudRepository;
import com.petShop.persistance.entity.Appointment;
import com.petShop.persistance.mapper.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AppointmentRepository implements AppointmentDomainRepository {
    @Autowired
    private AppointmentCrudRepository appointmentCrudRepository;

    @Autowired
    private AppointmentMapper mapper;

    @Override
    public Iterable<AppointmentDTO> getAll() {
        Iterable<Appointment> appointments = appointmentCrudRepository.findAll();
        return ((List<Appointment>) appointments).stream()
                .map(mapper::toAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppointmentDTO> getAppointmentById(int idAppointment) {
        Optional<Appointment> appointment = appointmentCrudRepository.findById(idAppointment);
        return appointment.map(mapper::toAppointmentDTO);
    }

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.toEntity(appointmentDTO);
        Integer appointmentId = appointment.getIdAppointment();

        if (appointmentId != null && existsAppointment(appointmentId)) {
            throw new IllegalArgumentException("El registro ya existe");
        }
        return mapper.toAppointmentDTO(appointmentCrudRepository.save(appointment));
    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.toEntity(appointmentDTO);
        Integer appointmentId = appointment.getIdAppointment();

        if (!existsAppointment(appointmentId)) {
            throw new IllegalArgumentException("El registro no existe");
        }
        return mapper.toAppointmentDTO(appointmentCrudRepository.save(appointment));
    }

    @Override
    public void delete(int idAppointment) {
        if (existsAppointment(idAppointment)) {
            appointmentCrudRepository.deleteById(idAppointment);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsAppointment(int idAppointment) {
        return appointmentCrudRepository.existsById(idAppointment);
    }

    @Override
    public long countAll() {
        return appointmentCrudRepository.count();
    }
}
