package com.naturalmente.Naturalmente.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Compra {

    @Id
    String _id;
    String fecha;
    int valor;

    public Compra(String _id, String fecha, int valor) {
        this._id = _id;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Compra() {

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
