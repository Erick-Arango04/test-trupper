package com.trupper.test.trupper_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PRODUCTOS")
public class Productos {

    @Id
    @GeneratedValue
    private Integer idProducto;
    private Integer idOrden;
    private String codigo;
    private String descripcion;
    private Double precio;


    public Productos(Integer idProducto, Integer idOrden, String codigo, String descripcion, Double precio) {
        this.idProducto = idProducto;
        this.idOrden = idOrden;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Productos() {
    }

    @Override
    public String toString() {
        return "Productos{" +
                "idProducto=" + idProducto +
                ", idOrden=" + idOrden +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }
}
