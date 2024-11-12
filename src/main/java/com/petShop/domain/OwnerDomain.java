package com.petShop.domain;


import com.petShop.persistance.entity.Pet;
import lombok.Data;

import java.util.List;

@Data
public class OwnerDomain {
    private Integer idPropietario;
    private String propietario;
    private String apellido;
    private String correo;
    private Integer numero;
    private String direccion;
}
