package com.desarrolloWeb.ProyectoAcquerello.servicio;

import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;


public interface ICarroComprasService {
    

    CarroCompras crearCarroCompras(CarroCompras newCarroCompras);

    CarroCompras actualizarCarroCompras(CarroCompras carroCompras, Long id);

    void deleteCarroCompras(Long id);

    
}
