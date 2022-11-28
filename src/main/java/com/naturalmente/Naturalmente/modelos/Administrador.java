package com.naturalmente.Naturalmente.modelos;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(String nombre) {
        super(nombre);
    }
}
