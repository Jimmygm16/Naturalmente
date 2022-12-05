package com.naturalmente.Naturalmente.controladores;

import com.naturalmente.Naturalmente.modelos.Administrador;
import com.naturalmente.Naturalmente.modelos.Cliente;
import com.naturalmente.Naturalmente.repositorios.RepositorioAdministradores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/administradores")
public class ControladorAdministradores {
    @Autowired
    private RepositorioAdministradores miRepositorioAdministradores;

    @GetMapping("")
    public List<Administrador> index(){return this.miRepositorioAdministradores.findAll();}
    @GetMapping("{id}")
    public Administrador show(@PathVariable String id){
        Administrador administradorActual = this.miRepositorioAdministradores.findById(id).orElse(null);
        return administradorActual;
    }
    @PostMapping("")
    public Administrador create(@RequestBody Administrador infoAdministrador){
        return this.miRepositorioAdministradores.save(infoAdministrador);
    }
    @PutMapping("{id}")
    public Administrador update(@PathVariable String id, @RequestBody Administrador infoAdministrador){
        Administrador encontrado = this.miRepositorioAdministradores.findById(id)
                .orElse(null);
        if(encontrado != null) {
            encontrado.setNombre(infoAdministrador.getNombre());
            encontrado.setCedula(infoAdministrador.getCedula());
            encontrado.setCorreo(infoAdministrador.getCorreo());
            encontrado.setTelefono(infoAdministrador.getTelefono());
            return this.miRepositorioAdministradores.save(encontrado);
        }else {
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Administrador eliminado = this.miRepositorioAdministradores.findById(id)
                .orElse(null);
        if (eliminado != null){
            this.miRepositorioAdministradores.delete(eliminado);
        }
    }
}
