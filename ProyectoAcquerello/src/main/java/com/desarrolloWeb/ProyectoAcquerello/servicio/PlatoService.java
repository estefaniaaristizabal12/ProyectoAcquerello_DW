package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.PlatoRepository;
import com.desarrolloWeb.ProyectoAcquerello.util.PlatoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class PlatoService implements IPlatoService{

    @Autowired
	private PlatoRepository repository;
    
    @Override
	public Plato createPlato(Plato newPlato) {
		return repository.save(newPlato);
	}

	@Override
	public Iterable<Plato> getPlatosL() {
		return repository.findAll();
	}

	@Override
    public Plato getPlatoById(Long idPlato){
        Optional<Plato> plato = repository.findById(idPlato);
        if (plato.isPresent()) {
			return plato.get();
		}
        else{
            System.out.println("ERROR");
            return plato.get();
        }
    }

	@Override
	public Plato getPlatoByNombre(String nombrePlato){
		Optional<Plato> plato = repository.findByNombre(nombrePlato);
        if (plato.isPresent()) {
			return plato.get();
		}
        else{
            System.out.println("ERROR");
            return plato.get();
        }
	}


	@Override
	public Plato updatePlato(Plato newPlato, Long idPlato) {
		Plato provider = getPlatoById(idPlato);
		provider.set_nombre(newPlato.get_nombre());
		provider.set_descripcion(newPlato.get_descripcion());
		provider.set_imagen(newPlato.get_imagen());
		provider.set_precio(newPlato.get_precio());
		repository.save(provider);
		return provider;
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
