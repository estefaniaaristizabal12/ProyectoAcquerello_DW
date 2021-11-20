package com.desarrolloWeb.ProyectoAcquerello.servicio;

import java.util.List;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPlatoService {

    Plato createPlato(Plato newPlato);

    Plato getPlatoById(Long idPlato);

    Iterable<Plato> getPlatosL();

    Plato updatePlato(Plato plato);

    void deletePlato(Long id);

    
}
