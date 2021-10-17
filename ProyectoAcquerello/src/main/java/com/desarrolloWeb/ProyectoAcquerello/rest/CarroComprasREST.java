package com.desarrolloWeb.ProyectoAcquerello.rest;
//import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
//import com.desarrolloWeb.ProyectoAcquerello.servicio.ICarroComprasService;

import java.util.List;
import java.util.ArrayList;

import com.desarrolloWeb.ProyectoAcquerello.dtos.CarroComprasDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import com.desarrolloWeb.ProyectoAcquerello.servicio.ICarroComprasService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarroComprasREST {

	
    @Autowired
	private ICarroComprasService carroComprasService;

	@PostMapping("/carrosC/crear")
	public CarroCompras createUsuario(@RequestBody CarroCompras nuevoCC) {
		return carroComprasService.createCarroCompras(nuevoCC);
	}


	//Falta probar!
	@GetMapping("/darCCUsuario")
	public List<CarroComprasDTO> getUsuarioById(@RequestParam(name = "idUsuario") Long idUsuario){
		List<CarroCompras> carroscompras = new ArrayList<>();
		carroscompras = carroComprasService.getCarroComprasByIdUsuario(idUsuario);
		List<CarroComprasDTO> result = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();
		
		for (CarroCompras carroCompras : carroscompras) {
			result.add(mapper.map(carroCompras, CarroComprasDTO.class));
		}
		return result;
	}

	@DeleteMapping("/eliminarCC")
	public String deleteCC(@RequestParam (name = "idCC") Long idCC) {
		Boolean res = carroComprasService.deleteCarroCompras(idCC);
		if(res == true){
			return "Se elimino correctamente";
		}
		else{
			return "Se genero un error ";
		}
	}

	/*
    @PostMapping("/carroCompras/crear")
	public CarroCompras createUsuario(@RequestBody CarroCompras newCarroCompras) {
		return carroComprasService.crearCarroCompras(newCarroCompras);
	}


    @PutMapping("/carroCompras/actualizar/{id}")
	public CarroCompras actualizarCarroCompras(@RequestBody CarroCompras newCarroCompras, @PathVariable Long id) {
		return carroComprasService.actualizarCarroCompras(newCarroCompras, id);
	}


    @DeleteMapping("/carroCompras/eliminar/{id}")
	public void deleteCarroCompras(@PathVariable Long id) {
		carroComprasService.deleteCarroCompras(id);
	}*/

      
}
