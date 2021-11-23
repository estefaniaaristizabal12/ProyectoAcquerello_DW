package com.desarrolloWeb.ProyectoAcquerello.servicio;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;

public interface IFacturaService {

    
    Factura createFactura(Factura newFactura);

    Factura getFacturaById(Long idFactura);

    Iterable<Factura> getFacturaLista();
    
    Iterable<Factura> getFacturaByIdUsuario(Long idUsuario);

    Iterable<Factura> getFacturaListaXUsuario(Factura factura);

    Factura updateFactura(Factura factura);

    void deleteFactura(Long idFactura);

}
