package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "citas")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idAppointment;

    @ManyToOne
    @JoinColumn(name = "id_mascota") //llave a foranea
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "id_empleado") //llave a foranea
    private Employee employee;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "fecha")
    private String date;

    public Integer getIdAppointment() { return idAppointment;}

    public void setIdAppointment(Integer idAppointment) {
        this.idAppointment = idAppointment;
    }
}
