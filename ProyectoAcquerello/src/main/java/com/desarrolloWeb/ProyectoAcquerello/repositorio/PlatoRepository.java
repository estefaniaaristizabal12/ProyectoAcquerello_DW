package com.desarrolloWeb.ProyectoAcquerello.repositorio;


import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.jpa.repository.Query;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;

public interface PlatoRepository extends CrudRepository<Plato, Long> {
    
    
}
