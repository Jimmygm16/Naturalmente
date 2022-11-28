package com.naturalmente.Naturalmente.controladores;

import com.naturalmente.Naturalmente.modelos.Compra;
import com.naturalmente.Naturalmente.repositorios.RepositorioCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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
        Compra productoActual = this.miRepositorioCompras.findById(id).orElse(null);
        return productoActual;
    }
    @PostMapping("")
    public Compra create(@RequestBody Compra infoProducto){
        return this.miRepositorioCompras.save(infoProducto);
    }
    @PutMapping("{id}")
    public Compra update(@PathVariable String id, @RequestBody Compra infoCompra){
        Compra encontrado = this.miRepositorioCompras.findById(id)
                .orElse(null);
        if(encontrado != null) {
            encontrado.setFecha(infoCompra.getFecha());
            encontrado.setValor(infoCompra.getValor());
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
