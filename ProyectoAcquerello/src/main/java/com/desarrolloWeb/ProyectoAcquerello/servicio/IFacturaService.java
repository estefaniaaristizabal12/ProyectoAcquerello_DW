package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;

public interface IFacturaService {

    Factura createFactura(Factura nuevoUsuario);

    Factura getFacturaById(Long idFactura);

    void deleteFactura(Long idFactura);

    
}
