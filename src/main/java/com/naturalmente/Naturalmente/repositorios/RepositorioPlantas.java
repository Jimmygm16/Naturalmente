package com.naturalmente.Naturalmente.repositorios;

import com.naturalmente.Naturalmente.modelos.Planta;
import com.naturalmente.Naturalmente.modelos.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepositorioPlantas extends MongoRepository<Planta, String> {
    @Query("{'miProducto.$id': ObjectId(?0)}")
    List<Producto> getPlantasEnProducto(String idProducto);
}
