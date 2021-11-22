package com.desarrolloWeb.ProyectoAcquerello.repositorio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;

@Repository
public interface PlatoRepository extends CrudRepository<Plato, Long> {

    @Query(value = "SELECT p FROM Plato p WHERE p._nombre = ?1")
    Optional<Plato> findByNombreP(String nombre);
    
}
