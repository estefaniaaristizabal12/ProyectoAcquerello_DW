package com.desarrolloWeb.ProyectoAcquerello.repositorio;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.jpa.repository.Query;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
@Repository
public interface PlatoRepository extends PagingAndSortingRepository<Plato, Long> {
    
    
}
