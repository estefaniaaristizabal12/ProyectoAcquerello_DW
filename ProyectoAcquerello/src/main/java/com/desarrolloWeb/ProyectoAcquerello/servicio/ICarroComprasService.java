package com.desarrolloWeb.ProyectoAcquerello.servicio;

import java.util.List;

import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;


public interface ICarroComprasService {

    CarroCompras createCarroCompras(CarroCompras newCarroCompras);

    CarroCompras updateCarroCompras(CarroCompras carroCompras);

    CarroCompras getCarroComprasById(Long idCarroCompras);

    Iterable<CarroCompras> getCarroComprasListaXUsuario(Long idUsuario);

    Iterable<CarroCompras> getCarroComprasLista();

    void deleteCarroCompras(Long idCarroCompras);

    void deleteCarroComprasXidUsuario(Long idUsuario);
}
