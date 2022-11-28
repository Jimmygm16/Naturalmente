package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioProductos extends MongoRepository<Producto, String> {
}
