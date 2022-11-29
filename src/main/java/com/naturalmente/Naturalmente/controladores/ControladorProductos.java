package com.naturalmente.Naturalmente.controladores;

import com.naturalmente.Naturalmente.modelos.Compra;
import com.naturalmente.Naturalmente.modelos.Producto;
import com.naturalmente.Naturalmente.repositorios.RepositorioCompras;
import com.naturalmente.Naturalmente.repositorios.RepositorioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ControladorProductos {

    @Autowired
    RepositorioProductos miRepositorioProductos;

    @Autowired
    RepositorioCompras miRepositorioCompras;

    public ControladorProductos(RepositorioProductos miRepositorioProductos) {
        this.miRepositorioProductos = miRepositorioProductos;
    }

    public ControladorProductos() {
    }

    @GetMapping("")
    public List<Producto> index(){
        return this.miRepositorioProductos.findAll();
    }
    @GetMapping("{id}")
    public Producto show(@PathVariable String id){
        Producto productoActual=this.miRepositorioProductos
                .findById(id)
                .orElse(null);
        return productoActual;
    }
    @PostMapping
    public Producto create(@RequestBody  Producto infoProducto){
        return this.miRepositorioProductos.save(infoProducto);
    }
    @PutMapping("{id}")
    public Producto update(@PathVariable String id,@RequestBody Producto infoProducto){
        Producto encontrado=this.miRepositorioProductos
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            encontrado.setNombre(infoProducto.getNombre());
            encontrado.setTipo(infoProducto.getTipo());
            encontrado.setExistencia(infoProducto.getExistencia());
            encontrado.setValor(infoProducto.getValor());
            return this.miRepositorioProductos.save(encontrado);
        }else{
            return null;
        }
    }

    @PutMapping("{id}/compras/{id_compra}")
    public Producto asociarProductoACompra(@PathVariable String id,
                                  @PathVariable String id_compra) {
        Producto productoEncontrado = miRepositorioProductos
                .findById(id)
                .orElse(null);
        Compra compraEncontrada = miRepositorioCompras
                .findById(id_compra)
                .orElse(null);
        if(productoEncontrado != null && compraEncontrada != null) {
            productoEncontrado.setCompra(compraEncontrada);
            return this.miRepositorioProductos.save(productoEncontrado);
        } else {
            return null;
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Producto encontrado=this.miRepositorioProductos
                .findById(id)
                .orElse(null);
        if (encontrado!=null){
            this.miRepositorioProductos.delete(encontrado);
        }
    }

    public RepositorioProductos getMiRepositorioProductos() {
        return miRepositorioProductos;
    }

    public void setMiRepositorioProductos(RepositorioProductos miRepositorioProductos) {
        this.miRepositorioProductos = miRepositorioProductos;
    }
}