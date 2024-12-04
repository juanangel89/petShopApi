package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // crea los getters and setters
@Entity // es el identificador para que el sprint sepa como tratar la clase
@Table (name = "empleados") // nombre de la tabla en la base de datos
public class Employee {
    @Id // identifica la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    @Column(name = "id")
    private Integer idEmployee;

    @Column(name = "nombre")
    private String nameEmployee;

    @Column(name = "cargo")
    private String position;

    @Column(name = "telefono")
    private String number;


    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }
}
