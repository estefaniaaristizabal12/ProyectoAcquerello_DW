package com.desarrolloWeb.ProyectoAcquerello.servicio;

import java.util.List;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPlatoService {

    Plato createPlato(Plato newPlato);

    Page<Plato> getPlatos(Pageable pageable);

    Plato getPlatoById(Long idPlato);

    Iterable<Plato> getPlatosL();

    Plato actualizarPlato(Plato plato, Long id);

    void deletePlato(Long id);

    
}
