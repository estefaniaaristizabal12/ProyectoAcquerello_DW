package com.desarrolloWeb.ProyectoAcquerello.rest;

import java.util.List;
import java.util.ArrayList;

import com.desarrolloWeb.ProyectoAcquerello.dtos.CarroComprasDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import com.desarrolloWeb.ProyectoAcquerello.servicio.ICarroComprasService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("carroCompras")
public class CarroComprasREST {

    @Autowired
	private ICarroComprasService carroComprasService;

	// - - - - - - - -  C   R   U  D  - - - - - - - - 

	@PostMapping("/crear")
	public CarroComprasDTO createCarroCompras(@RequestBody CarroComprasDTO nuevoCarroCompras) {
		CarroCompras carroCompras = new CarroCompras();
		ModelMapper mapper = new ModelMapper();
		carroCompras = mapper.map(nuevoCarroCompras, CarroCompras.class);
		carroCompras = carroComprasService.createCarroCompras(carroCompras);
		nuevoCarroCompras = mapper.map(carroCompras, CarroComprasDTO.class);
		return nuevoCarroCompras;
	}


	@GetMapping("/listaCarroCompras")
	public List<CarroComprasDTO> getCarroCompras() {
		Iterable<CarroCompras> carrosCompras = carroComprasService.getCarroComprasLista();
		List<CarroComprasDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		for (CarroCompras carroCompras : carrosCompras) {
			result.add(mapper.map(carroCompras, CarroComprasDTO.class));
		}
		return result;
	}



	@GetMapping("/listaCarroComprasXUsuario/{idUsuario}")
	public List<CarroComprasDTO> getCarroXUsuario(@PathVariable Long idUsuario) {
		ModelMapper mapper = new ModelMapper();
		Iterable<CarroCompras> carrosCompras = carroComprasService.getCarroComprasListaXUsuario(idUsuario);
		List<CarroComprasDTO> result = new ArrayList<>();
		for (CarroCompras car : carrosCompras) {
			result.add(mapper.map(car, CarroComprasDTO.class));
		}
		return result;
	}


	@PutMapping("/actualizarCarroCompras/{idCarroCompras}")
	public CarroComprasDTO actualizarCarroC(@RequestBody CarroComprasDTO newCarroCompras, @PathVariable Long idCarroCompras){
		CarroCompras carrosCompras = new CarroCompras();
		ModelMapper mapper = new ModelMapper();
		carrosCompras = mapper.map(newCarroCompras, CarroCompras.class);
		carrosCompras = carroComprasService.updateCarroCompras(carrosCompras);
		newCarroCompras = mapper.map(carrosCompras, CarroComprasDTO.class);
		return newCarroCompras;
	}


	@DeleteMapping("/eliminar/{idCarroCompras}")
	public Boolean deleteCarroC(@PathVariable Long idCarroCompras) {
		carroComprasService.deleteCarroCompras(idCarroCompras);
		return true;
	}

	@DeleteMapping("/eliminar/{idUsuario}")
	public Boolean deleteCarroCXidUsuario(@PathVariable Long idUsuario) {
		carroComprasService.deleteCarroCompras(idUsuario);
		return true;
	}
      
}
