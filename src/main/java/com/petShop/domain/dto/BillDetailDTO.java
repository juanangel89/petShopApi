package com.petShop.domain.dto;
import lombok.Data;
@Data
public class BillDetailDTO {
    private Integer idFacturaDetalle;
    private Integer idCita;
    private Integer idProducto;
    private Integer cantidad;
    private String fecha;
    private Double precio;

    public Integer getIdCita() {
        return idCita;
    }
    public Integer getIdProducto() {
        return idProducto;
    }
    public Integer getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

}
