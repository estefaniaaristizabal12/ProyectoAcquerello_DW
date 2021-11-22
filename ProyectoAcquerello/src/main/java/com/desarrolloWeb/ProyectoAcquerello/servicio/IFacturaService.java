package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacturaService {

    
    Factura createFactura(Factura newFactura);

    Factura getFacturaById(Long idFactura);

    Iterable<Factura> getFacturaLista();

    Iterable<Factura> getFacturaListaXUsuario(Long idUsuario);

    Factura updateFactura(Factura factura);

    void deleteFactura(Long idFactura);

    // Page<Factura> getFacturas(Pageable pageable);

    
}
