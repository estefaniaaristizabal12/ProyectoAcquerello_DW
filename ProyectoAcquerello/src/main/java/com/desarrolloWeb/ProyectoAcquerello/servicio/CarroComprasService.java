package com.desarrolloWeb.ProyectoAcquerello.servicio;

import java.util.Optional;

import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.CarroComprasRepository;
import com.desarrolloWeb.ProyectoAcquerello.util.PlatoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroComprasService implements ICarroComprasService{

    
    @Autowired
	private CarroComprasRepository repository;

    
    
    @Override
	public CarroCompras crearCarroCompras(CarroCompras newCarroCompras) {
		return repository.save(newCarroCompras);
	}


    
	@Override
	public CarroCompras actualizarCarroCompras(CarroCompras newCarroCompras, Long id) {

		return repository.findById(id).map(provider -> {

			provider.setCantidad(newCarroCompras.getCantidad());
			provider.setPrecio(newCarroCompras.getPrecio());

			return repository.save(provider);
            
		}).orElseGet(() -> {
			throw new PlatoNotFoundException(id);
		});
	}


    @Override
	public void deleteCarroCompras(Long id) {
		Optional<CarroCompras> carroCompras = repository.findById(id);

		if (carroCompras.isPresent()) {
			repository.delete(carroCompras.get());
		} else {
			throw new PlatoNotFoundException(id);
		}
	}
    
}
