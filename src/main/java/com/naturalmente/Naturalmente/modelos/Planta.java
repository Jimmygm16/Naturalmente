package com.naturalmente.Naturalmente.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Planta {
    @Id
    private String _id;
    private String nombre;
    private String funcionalidad;

    //constructores
    public Planta() {
    }

    public Planta(String nombre, String funcionalidad) {
        this.nombre = nombre;
        this.funcionalidad = funcionalidad;
    }

    //Getters and setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }
}
