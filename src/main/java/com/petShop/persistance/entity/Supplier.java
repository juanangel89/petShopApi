package com.petShop.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Proveedores")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Integer idSupplier;

    @Column(name = "nombre")
    private String nameSupplier;

    @Column(name = "correo")
    private String email;

    @Column(name = "telefono")
    private Integer number;

    @OneToMany(mappedBy = "supplier") //llave principal que crea una lista para la foranea
    private List<Product> products;

}
