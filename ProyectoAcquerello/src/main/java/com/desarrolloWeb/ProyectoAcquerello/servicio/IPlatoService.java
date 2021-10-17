package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;

public interface IPlatoService {

    Plato crearPlato(Plato newPlato);

    Plato actualizarPlato(Plato plato, Long id);

    void deletePlato(Long id);
    
	//Plato getPlatoById(Long idPlato);
}
