package com.trupper.test.trupper_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDENES")
public class Orden {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    private Date fecha;
    private Double total;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;


    public void agregarProductos(List<Producto> productos) {

        var listProducts = productos.stream()
                .peek(producto -> producto.setOrden(this)).toList();

        setProductos(listProducts);

    }
}
