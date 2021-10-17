package com.desarrolloWeb.ProyectoAcquerello.servicio;

import java.util.List;

import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;


public interface ICarroComprasService {

    CarroCompras createCarroCompras(CarroCompras newCarroCompras);

    List<CarroCompras> getCarroComprasByIdUsuario(Long idUsuario);

    CarroCompras actualizarCarroCompras(CarroCompras carroCompras, Long id);

    Boolean deleteCarroCompras(Long id);

    
}
