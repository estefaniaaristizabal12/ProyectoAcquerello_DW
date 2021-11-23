package com.desarrolloWeb.ProyectoAcquerello.servicio;
import java.util.List;
import java.util.Optional;
import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.CarroComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroComprasService implements ICarroComprasService{

    
    @Autowired
	private CarroComprasRepository repository;

    @Override
	public CarroCompras createCarroCompras(CarroCompras newCarroCompras) {
		System.out.println("Alerta 3> "+newCarroCompras.get_cantidad());
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

	//OJO ACA
	@Override
	public Iterable<CarroCompras> getCarroComprasByIdUsuario(Long idUsuario){
		return repository.findByUsuarioCC(idUsuario);
	}


	@Override
    public CarroCompras updateCarroCompras(CarroCompras newCarroCompras, Long idCC){
        CarroCompras provider = getCarroComprasById(newCarroCompras.get_id_CC());
		provider.set_cantidad(newCarroCompras.get_cantidad());
		provider.set_precio(newCarroCompras.get_precio());
		repository.save(provider);
		return provider;
    }

	@Override
    public Iterable<CarroCompras> getCarroComprasListaXUsuario(CarroCompras carroCompras){
        return repository.findByUsuarioc(carroCompras.getUsuarioc());
    }

	@Override
    public Iterable<CarroCompras> getCarroComprasLista(){
        return repository.findAll();
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
    public void deleteCarroComprasXUsuario(Long idUsuario){
        List<CarroCompras> carroCompras = repository.findByUsuarioCC(idUsuario);
		for(int i = 0; i < carroCompras.size(); i++){
			if(!carroCompras.get(i).equals(null)){
				repository.delete(carroCompras.get(i));
			}
			else {
				System.out.println("ERROR al eliminar carro de compras de usuario");
			} 
		}
    }

}
