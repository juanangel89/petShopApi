package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "citas")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idAppointment;

    @Column(name = "id_datos_citas")
    private Integer idDatesAppointments;

    @Column(name = "descripcion")
    private String description;
}
