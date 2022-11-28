package com.naturalmente.Naturalmente.controladores;

import com.naturalmente.Naturalmente.modelos.Producto;
import com.naturalmente.Naturalmente.modelos.Tienda;
import com.naturalmente.Naturalmente.repositorios.RepositorioTiendas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tiendas")
public class ControladorTiendas {

    @Autowired
    RepositorioTiendas miRepositorioTiendas;

    public ControladorTiendas(RepositorioTiendas miRepositorioTiendas) {
        this.miRepositorioTiendas = miRepositorioTiendas;
    }

    public ControladorTiendas() {
    }

    @GetMapping("")
    public List<Tienda> index(){
        return this.miRepositorioTiendas.findAll();
    }
    @GetMapping("{id}")
    public Tienda show(@PathVariable String id){
        Tienda tiendaActual = this.miRepositorioTiendas
                .findById(id)
                .orElse(null);
        return tiendaActual;
    }
    @PostMapping
    public Tienda create(@RequestBody  Tienda infoTienda ){
        return this.miRepositorioTiendas.save(infoTienda);
    }
    @PutMapping("{id}")
    public Tienda update(@PathVariable String id,@RequestBody Tienda infoTienda){
        Tienda encontrado=this.miRepositorioTiendas
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            encontrado.setNombre(infoTienda.getNombre());
            encontrado.setNIT(infoTienda.getNIT());
            encontrado.setDireccion(infoTienda.getNombre());
            return this.miRepositorioTiendas.save(encontrado);
        }else{
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Tienda encontrado=this.miRepositorioTiendas
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            this.miRepositorioTiendas.delete(encontrado);
        }
    }

    public RepositorioTiendas getMiRepositorioTiendas() {
        return miRepositorioTiendas;
    }

    public void setMiRepositorioTiendas(RepositorioTiendas miRepositorioTiendas) {
        this.miRepositorioTiendas = miRepositorioTiendas;
    }
}
