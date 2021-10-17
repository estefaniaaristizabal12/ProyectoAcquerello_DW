package com.desarrolloWeb.ProyectoAcquerello.repositorio;

import org.springframework.stereotype.Repository;

import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarroComprasRepository extends JpaRepository <CarroCompras, Long>{
    

    
}