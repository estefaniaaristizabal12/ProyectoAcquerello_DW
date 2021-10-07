package com.desarrolloWeb.ProyectoAcquerello.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
    
}
