package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepositorioProductos extends MongoRepository<Producto, String> {
    @Query("{'miCompra.$id': ObjectId(?0)}")
    List<Producto> getProductosEnCompra(String idCompra);
}
