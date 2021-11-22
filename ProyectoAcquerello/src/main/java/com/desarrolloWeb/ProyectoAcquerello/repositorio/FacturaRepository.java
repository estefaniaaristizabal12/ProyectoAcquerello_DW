package com.desarrolloWeb.ProyectoAcquerello.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

@Repository
public interface FacturaRepository extends  CrudRepository<Factura, Long>  {
    List<Factura> findByUsuariof(Usuario usuariof);   
}