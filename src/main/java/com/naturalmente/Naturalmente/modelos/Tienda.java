package com.naturalmente.Naturalmente.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Tienda {

    @Id
    String _id;
    String nombre;
    String NIT;
    String direccion;

    public Tienda(String _id, String nombre, String NIT, String direccion) {
        this._id = _id;
        this.nombre = nombre;
        this.NIT = NIT;
        this.direccion = direccion;
    }

    public Tienda() {

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

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
