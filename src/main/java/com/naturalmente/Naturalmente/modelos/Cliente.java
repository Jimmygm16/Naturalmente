package com.naturalmente.Naturalmente.modelos;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()

public class Cliente extends Usuario{

    //Constructores
    public Cliente() {
    }
    public Cliente(String _id,String nombre, String cedula, String correo, String telefono) {
        super(nombre, cedula, correo, telefono);
    }

    //Getters and setters


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
