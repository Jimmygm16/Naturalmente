package com.naturalmente.Naturalmente.modelos;

import org.springframework.data.annotation.Id;

public class Producto {

    @Id
    String _id;
    String nombre;
    String tipo;
    int existencia;
    int valor;

    public Producto(String _id, String nombre, String tipo, int existencia, int valor) {
        this._id = _id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.existencia = existencia;
        this.valor = valor;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
