package com.petShop.persistance.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Productos")
public class Product {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idProduct;

    @Column(name = "nombre")
    private String nameProduct;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "existencias")
    private Integer stock;

    @Column(name = "precio")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_proveedor") //llave foranea
    private Supplier supplier;

    public Integer getIdProduct() { return idProduct;}

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
