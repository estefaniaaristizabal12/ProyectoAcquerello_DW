package com.desarrolloWeb.ProyectoAcquerello.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.data.jpa.repository.Query;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;

@Repository
public interface FacturaRepository extends  CrudRepository<Factura, Long>  {
   
}