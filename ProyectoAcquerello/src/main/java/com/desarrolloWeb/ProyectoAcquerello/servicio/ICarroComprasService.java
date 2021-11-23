package com.desarrolloWeb.ProyectoAcquerello.servicio;
import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;


public interface ICarroComprasService {

    CarroCompras createCarroCompras(CarroCompras newCarroCompras);

    // List<CarroCompras> getCarroComprasByIdUsuario(Long idUsuario);

    CarroCompras updateCarroCompras(CarroCompras carroCompras, Long idCC);

    CarroCompras getCarroComprasById(Long idCarroCompras);


    //OJO ACA
    Iterable<CarroCompras> getCarroComprasByIdUsuario(Long idUsuario);

    void deleteCarroComprasXUsuario(Long idUsuario);

    Iterable<CarroCompras> getCarroComprasLista();

    void deleteCarroCompras(Long idCarroCompras);

    Iterable<CarroCompras> getCarroComprasListaXUsuario(CarroCompras carroCompras);






    
}
