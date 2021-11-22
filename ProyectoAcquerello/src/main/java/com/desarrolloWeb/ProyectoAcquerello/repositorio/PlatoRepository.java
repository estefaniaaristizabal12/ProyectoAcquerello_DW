package com.desarrolloWeb.ProyectoAcquerello.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;

@Repository
public interface PlatoRepository extends CrudRepository<Plato, Long> {
    
}
