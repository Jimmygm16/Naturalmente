package com.naturalmente.Naturalmente.modelos;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()

public class Cliente extends Usuario{
    private String telefono;

    //Constructores
    public Cliente() {
    }
    public Cliente(String nombre, String telefono) {
        super(nombre);
        this.telefono = telefono;
    }

    //Getters and setters


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
