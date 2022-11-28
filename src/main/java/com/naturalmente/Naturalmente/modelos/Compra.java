package com.naturalmente.Naturalmente.modelos;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Compra {

    @Id
    String _id;
    String nombre;
    String tipo;
    int existencias;
    int precio;

    public Compra(String _id, String nombre, String tipo, int existencias, int precio) {
        this._id = _id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.existencias = existencias;
        this.precio = precio;
    }

    public Compra() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
