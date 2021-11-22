package com.desarrolloWeb.ProyectoAcquerello.servicio;

import java.util.List;

import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;


public interface ICarroComprasService {

    CarroCompras createCarroCompras(CarroCompras newCarroCompras);

    // List<CarroCompras> getCarroComprasByIdUsuario(Long idUsuario);

    CarroCompras updateCarroCompras(CarroCompras carroCompras);

    CarroCompras getCarroComprasById(Long idCarroCompras);

    Iterable<CarroCompras> getCarroComprasLista();

    void deleteCarroCompras(Long idCarroCompras);

    Iterable<CarroCompras> getCarroComprasListaXUsuario(CarroCompras carroCompras);






    
}
