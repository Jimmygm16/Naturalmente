package com.naturalmente.Naturalmente.modelos;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Compra {

    @Id
    private
    String _id;
    private String nombre;
    private String tipo;
    private int existencias;
    private int precio;

    public Compra(String _id, String nombre, String tipo, int existencias, int precio) {
        this.set_id(_id);
        this.setNombre(nombre);
        this.setTipo(tipo);
        this.setExistencias(existencias);
        this.setPrecio(precio);
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
