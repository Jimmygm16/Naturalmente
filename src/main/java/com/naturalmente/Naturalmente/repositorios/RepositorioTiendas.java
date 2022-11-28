package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Tienda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioTiendas extends MongoRepository<Tienda, String> {
}