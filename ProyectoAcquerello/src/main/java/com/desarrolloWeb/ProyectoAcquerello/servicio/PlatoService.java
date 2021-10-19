package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.PlatoRepository;
import com.desarrolloWeb.ProyectoAcquerello.util.PlatoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PlatoService implements IPlatoService{

    @Autowired
	private PlatoRepository repository;
    
    @Override
	public Plato createPlato(Plato newPlato) {
		return repository.save(newPlato);
	}

	@Override
	public Page<Plato> getPlatos(Pageable pageable) {
		return repository.findAll(pageable);
	} 

	@Override
	public Iterable<Plato> getPlatosL() {
		return repository.findAll();
	}

	@Override
    public Plato getPlatoById(Long idUsuario){
        Optional<Plato> plato = repository.findById(idUsuario);
        if (plato.isPresent()) {
			return plato.get();
		}
        else{
            System.out.println("ERRORRR");
            return plato.get();
        }
    }


	@Override
	public Plato updatePlato(Plato newPlato) {
		Optional<Plato> pro = repository.findById(newPlato.get_idPlato());
		Plato provider = pro.get();
		provider.set_nombre(newPlato.get_nombre());
		provider.set_descripcion(newPlato.get_descripcion());
		provider.set_imagen(newPlato.get_imagen());
		provider.set_precio(newPlato.get_precio());
		return repository.save(provider);
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


    
}
