package com.naturalmente.Naturalmente.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private int valor;
    private int existencia;
    @DBRef
    private Compra miCompra;

    //Constructores

    public Producto() {
    }

    public Producto(String id, String nombre, String tipo, int valor, int existencia) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.existencia = existencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public Compra getMiCompra() {
        return miCompra;
    }

    public void setMiCompra(Compra compra) {
        this.miCompra = compra;
    }
}
