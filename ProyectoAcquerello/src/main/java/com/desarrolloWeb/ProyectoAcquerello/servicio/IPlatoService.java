package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;

public interface IPlatoService {

    Plato createPlato(Plato newPlato);

    Plato getPlatoById(Long idPlato);

    Iterable<Plato> getPlatosL();

    Plato updatePlato(Plato plato, Long idPlato);

    void deletePlato(Long id);

    
}
