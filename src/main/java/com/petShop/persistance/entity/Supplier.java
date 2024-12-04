package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "Proveedores")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idSupplier;

    @Column(name = "nombre")
    private String nameSupplier;

    @Column(name = "correo")
    private String email;

    @Column(name = "telefono")
    private String number;

//    @OneToMany(mappedBy = "supplier") //llave principal que crea una lista para la foranea
//    private List<Product> products;
    public Integer getIdSupplier() { return idSupplier;}

    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }
}
