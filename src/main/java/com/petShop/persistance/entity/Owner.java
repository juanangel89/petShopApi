package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table (name = "propietarios")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idOwner;

    @Column(name = "nombre")
    private String nameOwner;

    @Column(name = "apellido")
    private String lastNameOwner;

    @Column(name = "correo")
    private String email;

    @Column(name = "telefono")
    private Integer number;

    @Column(name = "direccion")
    private String address;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public Integer getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Integer idOwner) {
        this.idOwner = idOwner;
    }

}
