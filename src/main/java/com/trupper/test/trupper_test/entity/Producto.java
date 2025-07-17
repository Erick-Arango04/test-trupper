package com.trupper.test.trupper_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue
    private Integer idProducto;

    @ManyToOne
    @JoinColumn(name = "id_Orden")
    private Orden orden;

    private String codigo;
    private String descripcion;
    private Double precio;

}
