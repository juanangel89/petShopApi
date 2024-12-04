package com.petShop.domain.dto;

import lombok.Data;

@Data
public class AppointmentDTO {
    private Integer idCita;

    private Integer mascotaDominio;

    private Integer empleadoDominio;

    private String descripcion;

    private String fecha;
}
