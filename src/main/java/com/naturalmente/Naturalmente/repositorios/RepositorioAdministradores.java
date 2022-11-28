package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Administrador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioAdministradores extends MongoRepository<Administrador, String> {
}
