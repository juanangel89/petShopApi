package com.petShop.persistance;

import com.petShop.persistance.crud.AppointmentCrudRepository;
import com.petShop.persistance.entity.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class AppointmentRepository {
    private AppointmentCrudRepository appointmentCrudRepository;

    public List<Appointment> getAll(){
        return (List<Appointment>) appointmentCrudRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(int idAppointment){
        return appointmentCrudRepository.findById(idAppointment);
    }

    public Appointment save(Appointment appointment){
        return appointmentCrudRepository.save(appointment);
    }

    public void deleted(int idAppointment){
        appointmentCrudRepository.deleteById(idAppointment);
    }

    public boolean existsAppointment(int idAppointment){
        return appointmentCrudRepository.existsById(idAppointment);
    }

    public long countAll(){
        return appointmentCrudRepository.count();
    }

}
