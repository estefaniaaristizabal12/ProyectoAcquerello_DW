package com.desarrolloWeb.ProyectoAcquerello.servicio;

import java.util.List;
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
	public CarroCompras createCarroCompras(CarroCompras newCarroCompras) {
		return repository.save(newCarroCompras);
	}

	// @Override
	// public List<CarroCompras> getCarroComprasByIdUsuario(Long idUsuario){
	// 	return repository.findByUsuarioc(idUsuario);
	// }

	@Override
    public CarroCompras getCarroComprasById(Long idCarroCompras){
        Optional<CarroCompras> carroCompras = repository.findById(idCarroCompras);
        if (carroCompras.isPresent()) {
			return carroCompras.get();
		}
        else{
            System.out.println("ERROR");
            return carroCompras.get();
        }
    }


	@Override
    public CarroCompras updateCarroCompras(CarroCompras newCarroCompras){
        CarroCompras provider = getCarroComprasById(newCarroCompras.get_id_CC());
		provider.setPlatoc(newCarroCompras.getPlatoc());
		provider.setUsuarioc(newCarroCompras.getUsuarioc());
		provider.set_cantidad(newCarroCompras.get_cantidad());
		provider.set_foto(newCarroCompras.get_foto());
		provider.set_id_CC(newCarroCompras.get_id_CC());
		provider.set_nombreProducto(newCarroCompras.get_foto());
		provider.set_precio(newCarroCompras.get_precio());
		repository.save(provider);
		return provider;

    }


	@Override
    public void deleteCarroCompras(Long idCarroCompras){
        Optional<CarroCompras> carroCompras = repository.findById(idCarroCompras);
		if (carroCompras.isPresent()) {
			repository.delete(carroCompras.get());
		} else {
			System.out.println("ERROR");
		} 

    }

	@Override
    public Iterable<CarroCompras> getCarroComprasListaXUsuario(CarroCompras carroCompras){
        return repository.findByUsuarioc(carroCompras.getUsuarioc());
    }



	@Override
    public Iterable<CarroCompras> getCarroComprasLista(){
        return repository.findAll();
    }

}
