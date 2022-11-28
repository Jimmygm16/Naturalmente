package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioCompras extends MongoRepository<Compra, String> {
}
