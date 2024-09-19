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
    private Integer idDetailBill;

    @Column(name = "id_productos_provedores")
    private Integer idProductSupplier;

    @Column(name = "id_cita")
    private Integer idAppointment;

    @Column(name = "cantidad")
    private Integer amountProduct;

    @Column(name = "monto_cita")
    private Integer priceAppointment;

    @Column(name = "monto_producto")
    private Integer dateProduc;

    @Column(name = "fecha")
    private String date;

}
