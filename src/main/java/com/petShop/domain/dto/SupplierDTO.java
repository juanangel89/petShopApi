package com.petShop.domain.dto;

import lombok.Data;

@Data
public class SupplierDTO {
    private Integer idProveedor;
    private String nombre;
    private String correo;
    private String telefono;
}
