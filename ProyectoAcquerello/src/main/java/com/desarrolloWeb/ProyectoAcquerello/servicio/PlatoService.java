package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.PlatoRepository;
import com.desarrolloWeb.ProyectoAcquerello.util.PlatoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlatoService implements IPlatoService{



    @Autowired
	private PlatoRepository repository;

    
    
    @Override
	public Plato crearPlato(Plato newPlato) {
		return repository.save(newPlato);
	}


    
	@Override
	public Plato actualizarPlato(Plato newPlato, Long id) {

		return repository.findById(id).map(provider -> {
			provider.setNombre(newPlato.getNombre());
			provider.setDescripcion(newPlato.getDescripcion());
			provider.setPrecio(newPlato.getPrecio());


			return repository.save(provider);
            
		}).orElseGet(() -> {
			throw new PlatoNotFoundException(id);
		});
	}


    @Override
	public void deletePlato(Long id) {
		Optional<Plato> plato = repository.findById(id);

		if (plato.isPresent()) {
			repository.delete(plato.get());
		} else {
			throw new PlatoNotFoundException(id);
		}
	}



    /*
    @Override
	public Plato getPlatoById(Long idPlato) {

        return repository.findById(idPlato).orElseThrow(() -> new EquipoNotFoundException(idPlato));
	}
    */

    
}
