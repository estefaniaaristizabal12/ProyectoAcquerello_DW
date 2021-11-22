package com.desarrolloWeb.ProyectoAcquerello.repositorio;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CarroComprasRepository extends JpaRepository <CarroCompras, Long>{

    List<CarroCompras> findByUsuarioc (Usuario usuario);   
    

}
