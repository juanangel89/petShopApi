package com.petShop.persistance.crud;

import com.petShop.persistance.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentCrudRepository extends CrudRepository<Appointment,Integer> {
}
