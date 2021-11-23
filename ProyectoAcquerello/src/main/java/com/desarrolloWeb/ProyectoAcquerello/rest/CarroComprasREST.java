package com.desarrolloWeb.ProyectoAcquerello.rest;
import java.util.List;
import java.util.ArrayList;
import com.desarrolloWeb.ProyectoAcquerello.dtos.CarroComprasDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import com.desarrolloWeb.ProyectoAcquerello.servicio.ICarroComprasService;
import com.desarrolloWeb.ProyectoAcquerello.servicio.IPlatoService;
import com.desarrolloWeb.ProyectoAcquerello.servicio.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("carroCompras")
public class CarroComprasREST {

	
    @Autowired
	private ICarroComprasService carroComprasService;

	@Autowired
	private IPlatoService platoService;

	@Autowired
	private IUsuarioService usuarioService;




	// - - - - - - - -  C   R   U  D  - - - - - - - - 

	@PostMapping("/crear/{emailUsuario}")
	public Boolean createCarroCompras(@RequestBody CarroComprasDTO nuevoCarroCompras, @PathVariable String emailUsuario) {
		CarroCompras carroCompras = new CarroCompras();
		ModelMapper mapper = new ModelMapper();
		carroCompras = mapper.map(nuevoCarroCompras, CarroCompras.class);
		carroCompras.setUsuarioc(usuarioService.getUsuarioByEmail(emailUsuario));
		carroCompras.setPlatoc(platoService.getPlatoByNombre(carroCompras.get_nombreProducto()));
		carroCompras = carroComprasService.createCarroCompras(carroCompras);
		if(!carroCompras.equals(null)) return true;
		else return false;
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



	@GetMapping("/listaCarroComprasXUsuario/{id_CC}")
	public List<CarroComprasDTO> getFacturasXUsuario(@PathVariable Long idCarroCompras) {
		CarroCompras carroCompras = carroComprasService.getCarroComprasById(idCarroCompras);
		ModelMapper mapper = new ModelMapper();
		Iterable<CarroCompras> carrosCompras = carroComprasService.getCarroComprasListaXUsuario(carroCompras);
		List<CarroComprasDTO> result = new ArrayList<>();
		for (CarroCompras fact : carrosCompras) {
			result.add(mapper.map(fact, CarroComprasDTO.class));
		}
		return result;
	}

	//OJO ACA
	@GetMapping("/listaCarroComprasXidUsuario/{idUsuario}")
	public List<CarroComprasDTO> getCarroComprasXIdUsuario(@PathVariable Long idUsuario) {
		Iterable<CarroCompras> carrosCompras = carroComprasService.getCarroComprasByIdUsuario(idUsuario);
		ModelMapper mapper = new ModelMapper();
		List<CarroComprasDTO> result = new ArrayList<>();
		CarroComprasDTO cd = new CarroComprasDTO();
		for (CarroCompras cc : carrosCompras) {
			cd = mapper.map(cc, CarroComprasDTO.class);
			cd.setUsuarioc(null);
			cd.setPlatoc( null);
		    result.add(cd);
		}
		return result;
	}



	@PutMapping("/actualizarCarroCompras/{idCarroCompras}")
	public Boolean actualizarPlato(@RequestBody CarroComprasDTO newCarroCompras, @PathVariable Long idCarroCompras){
		CarroCompras carrosCompras = new CarroCompras();
		ModelMapper mapper = new ModelMapper();
		carrosCompras = mapper.map(newCarroCompras, CarroCompras.class);
		carrosCompras.setPlatoc(null);
		carrosCompras.setUsuarioc(null);
		carrosCompras = carroComprasService.updateCarroCompras(carrosCompras, idCarroCompras);
		newCarroCompras = mapper.map(carrosCompras, CarroComprasDTO.class);
		return true;
	}


	@DeleteMapping("/eliminar/{idCarroCompras}")
	public Boolean deletePlato(@PathVariable Long idCarroCompras) {
		carroComprasService.deleteCarroCompras(idCarroCompras);
		return true;
	}

	@DeleteMapping("/eliminarXUsuario/{idUsuario}")
	public Boolean deletePlatoXUsuario(@PathVariable Long idUsuario) {
		carroComprasService.deleteCarroComprasXUsuario(idUsuario);
		return true;
	}
      
}
