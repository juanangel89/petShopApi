package com.petShop.domain.dto;


import lombok.Data;

@Data
public class ProductDTO {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Integer existencias;
    private Double precio;
    private Integer proveedorDominio;
}

