package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Planta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPlantas extends MongoRepository<Planta, String> {

}
