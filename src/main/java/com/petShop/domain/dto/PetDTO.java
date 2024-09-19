package com.petShop.domain.dto;

import com.petShop.persistance.entity.Owner;
import lombok.Data;

@Data
public class PetDTO {
    private Integer idMascota;
    private String mascota;
    private String especie;
    private int edad;
    private String genero;
    private Owner propietario;
}
