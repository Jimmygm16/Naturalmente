package com.naturalmente.Naturalmente.controladores;

import com.naturalmente.Naturalmente.modelos.Cliente;
import com.naturalmente.Naturalmente.modelos.Compra;
import com.naturalmente.Naturalmente.modelos.Producto;
import com.naturalmente.Naturalmente.repositorios.RepositorioClientes;
import com.naturalmente.Naturalmente.repositorios.RepositorioCompras;
import com.naturalmente.Naturalmente.repositorios.RepositorioProductos;
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
    @Autowired
    private RepositorioClientes miRepositorioClientes;

    @GetMapping("")
    public List<Compra> index(){return this.miRepositorioCompras.findAll();}
    @GetMapping("{id}")
    public Compra show(@PathVariable String id){
        Compra productoActual = this.miRepositorioCompras.findById(id).orElse(null);
        return productoActual;
    }

    @GetMapping("clientes/{id_cliente}")
    public List<Compra> getComprasCliente(@PathVariable String idCliente){
        return this.miRepositorioCompras.getComprasEnCliente(idCliente);
    }
    @PostMapping("clientes/{id_cliente}")
    public Compra create(@RequestBody Compra infoCompra,
                         @PathVariable String id_cliente) {
        Cliente clienteTemporal = miRepositorioClientes
                .findById(id_cliente)
                .orElse(null);
        if(clienteTemporal != null) {
            infoCompra.setMiCliente(clienteTemporal);
            return this.miRepositorioCompras.save(infoCompra);
        } else {
            return null;
        }
    }

    @PutMapping("{id}/clientes/{id_cliente}")
    public Compra update(@PathVariable String id,
                         @PathVariable String id_cliente,
                         @RequestBody Compra infoCompra) {
        Compra compraEncontrada = this.miRepositorioCompras
                .findById(id)
                .orElse(null);
        Cliente clienteEncontrado = this.miRepositorioClientes
                .findById(id_cliente)
                .orElse(null);
        if(compraEncontrada != null && clienteEncontrado != null) {
            compraEncontrada.setFecha(infoCompra.getFecha());
            compraEncontrada.setValor(infoCompra.getValor());
            compraEncontrada.setMiCliente(clienteEncontrado);
            return this.miRepositorioCompras.save(compraEncontrada);
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
