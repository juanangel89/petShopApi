package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "facturas")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idBill;

    @Column(name = "id_facturas_detalles")
    private Integer idBillDetails;

    @Column(name = "total")
    private Integer total;

    @Column(name = "fecha")
    private String date;
}
