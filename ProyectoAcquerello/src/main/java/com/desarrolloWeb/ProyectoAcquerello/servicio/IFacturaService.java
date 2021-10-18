package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacturaService {

    Factura createFactura(Factura nuevoUsuario);

    Factura getFacturaById(Long idFactura);

    Boolean deleteFactura(Long idFactura);

    Page<Factura> getFacturas(Pageable pageable);

    
}
