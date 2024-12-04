package com.petShop.domain.service;

import com.petShop.domain.dto.AppointmentDTO;
import com.petShop.domain.repository.AppointmentDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AppointmentService {
    @Autowired
    private AppointmentDomainRepository appointmentDomainRepository; //llamar a petrepositoriy

    public Iterable<AppointmentDTO> getAll() {
        return appointmentDomainRepository.getAll();
    }

    public Optional<AppointmentDTO> getAppointmentById(int id) {return appointmentDomainRepository.getAppointmentById(id);}

    public AppointmentDTO save(AppointmentDTO appointmentDTO){return appointmentDomainRepository.save(appointmentDTO);}

    public AppointmentDTO update(AppointmentDTO appointmentDTO){return appointmentDomainRepository.update(appointmentDTO);}

    public void delete(int id){
        appointmentDomainRepository.delete(id);
    }

    public boolean existsAppointment(int id) {return appointmentDomainRepository.existsAppointment(id);}

    public long countAll() {return appointmentDomainRepository.countAll();}
}
