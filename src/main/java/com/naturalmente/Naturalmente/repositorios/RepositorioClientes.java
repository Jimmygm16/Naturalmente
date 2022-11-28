package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioClientes extends MongoRepository<Cliente, String> {
}
