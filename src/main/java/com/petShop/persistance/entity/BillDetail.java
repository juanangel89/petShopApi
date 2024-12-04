package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "factura_detalles")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idBillDetail;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = true)
    private Appointment appointment; // Relación con la entidad Appointment

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = true)
    private Product product; // Relación con la entidad Product

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "fecha")
    private String date;

    @Column(name = "precio_unitario")
    private Double price;

    public Integer getIdBillDetail() {
        return idBillDetail;
    }

    public void setIdBillDetail(Integer idBillDetail) {
        this.idBillDetail = idBillDetail;
    }

}
