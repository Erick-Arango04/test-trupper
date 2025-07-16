package com.trupper.test.trupper_test.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;


public class RespuestaGeneral {
    private Integer codigo;
    private String mensaje;
    private Object descripcion;


    public RespuestaGeneral(Integer codigo, String mensaje, Object descripcion) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.descripcion = descripcion;
    }

    public RespuestaGeneral(){
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setDescripcion(Object descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Object getDescripcion() {
        return descripcion;
    }
}
