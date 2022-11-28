package com.naturalmente.Naturalmente.controladores;

import com.naturalmente.Naturalmente.modelos.Compra;
import com.naturalmente.Naturalmente.modelos.Planta;
import com.naturalmente.Naturalmente.repositorios.RepositorioCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/compras")
public class ControladorCompras {
    @Autowired
    private RepositorioCompras miRepositorioCompras;

    @GetMapping("")
    public List<Compra> index(){return this.miRepositorioCompras.findAll();}
    @GetMapping("{id}")
    public Compra show(@PathVariable String id){
        Compra compraActual = this.miRepositorioCompras.findById(id).orElse(null);
        return compraActual;
    }
    @PostMapping("")
    public Compra create(@RequestBody Compra infoCompra){
        return this.miRepositorioCompras.save(infoCompra);
    }
    @PutMapping("{id}")
    public Compra update(@PathVariable String id, @RequestBody Compra infoCompra){
        Compra encontrado = this.miRepositorioCompras.findById(id)
                .orElse(null);
        if(encontrado != null) {
            encontrado.setExistencias(infoCompra.getExistencias());
            encontrado.setNombre(infoCompra.getNombre());
            encontrado.setTipo(infoCompra.getTipo());
            encontrado.setPrecio(infoCompra.getPrecio());
            return this.miRepositorioCompras.save(encontrado);
        }else {
            return null;
        }
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Compra eliminado = this.miRepositorioCompras.findById(id)
                .orElse(null);
        if (eliminado != null){
            this.miRepositorioCompras.delete(eliminado);
        }
    }
}
