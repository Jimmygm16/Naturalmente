package com.naturalmente.Naturalmente.controladores;

import com.naturalmente.Naturalmente.modelos.Planta;
import com.naturalmente.Naturalmente.repositorios.RepositorioPlantas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/plantas")
public class ControladorPlantas {
    @Autowired
    private RepositorioPlantas miRepositorioPlantas;

    @GetMapping("")
    public List<Planta> index(){return this.miRepositorioPlantas.findAll();}
    @GetMapping("{id}")
    public Planta show(@PathVariable String id){
        Planta plantaActual = this.miRepositorioPlantas.findById(id).orElse(null);
        return plantaActual;
    }
    @PostMapping("")
    public Planta create(@RequestBody Planta infoPlanta){
        return this.miRepositorioPlantas.save(infoPlanta);
    }
    @PutMapping("{id}")
    public Planta update(@PathVariable String id, @RequestBody Planta infoPlanta){
        Planta encontrado = this.miRepositorioPlantas.findById(id)
                .orElse(null);
        if(encontrado != null) {
            encontrado.setFuncionalidad(infoPlanta.getFuncionalidad());
            encontrado.setNombre(infoPlanta.getNombre());
            return this.miRepositorioPlantas.save(encontrado);
        }else {
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Planta eliminado = this.miRepositorioPlantas.findById(id)
                .orElse(null);
        if (eliminado != null){
            this.miRepositorioPlantas.delete(eliminado);
        }
    }

}
