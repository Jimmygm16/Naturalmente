package com.naturalmente.Naturalmente.controladores;

import com.naturalmente.Naturalmente.modelos.Cliente;
import com.naturalmente.Naturalmente.repositorios.RepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ControladorClientes {
    @Autowired
    private RepositorioClientes miRepositorioClientes;
    @GetMapping("")
    public List<Cliente> index(){return this.miRepositorioClientes.findAll();}
    @GetMapping("{id}")
    public Cliente show(@PathVariable String id){
        Cliente clienteActual = this.miRepositorioClientes.findById(id).orElse(null);
        return clienteActual;
    }
    @PostMapping("")
    public Cliente create(@RequestBody Cliente infoCliente){
        return this.miRepositorioClientes.save(infoCliente);
    }
    @PutMapping("{id}")
    public Cliente update(@PathVariable String id, @RequestBody Cliente infoCliente){
        Cliente encontrado = this.miRepositorioClientes.findById(id)
                .orElse(null);
        if(encontrado != null) {
            encontrado.setNombre(infoCliente.getNombre());
            encontrado.setCedula(infoCliente.getCedula());
            encontrado.setCorreo(infoCliente.getCorreo());
            encontrado.setTelefono(infoCliente.getTelefono());
            return this.miRepositorioClientes.save(encontrado);
        }else {
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Cliente eliminado = this.miRepositorioClientes.findById(id)
                .orElse(null);
        if (eliminado != null){
            this.miRepositorioClientes.delete(eliminado);
        }
    }
}
