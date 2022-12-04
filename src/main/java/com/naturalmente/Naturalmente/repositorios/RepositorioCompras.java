package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Compra;
import com.naturalmente.Naturalmente.modelos.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepositorioCompras extends MongoRepository<Compra, String> {
    @Query("{'miCliente.$id': ObjectId(?0)}")
    List<Producto> getComprasEnCliente(String idCliente);
}
