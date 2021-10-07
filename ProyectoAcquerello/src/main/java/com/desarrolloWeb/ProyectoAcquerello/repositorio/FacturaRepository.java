package com.desarrolloWeb.ProyectoAcquerello.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;
public interface FacturaRepository extends  JpaRepository<Factura, Long>  {

    

}