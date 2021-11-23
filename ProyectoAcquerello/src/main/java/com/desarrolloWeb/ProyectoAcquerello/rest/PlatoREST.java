package com.desarrolloWeb.ProyectoAcquerello.rest;



import java.util.ArrayList;
import java.util.List;

import com.desarrolloWeb.ProyectoAcquerello.dtos.PlatoDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.servicio.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("plato")
public class PlatoREST {

    @Autowired
	private IPlatoService platoService;


	// - - - - - - - -  C   R   U  D  - - - - - - - - 


	@PostMapping("/crear")
	public PlatoDTO crearPlato(@RequestBody PlatoDTO newPlato) {
		Plato plato = new Plato();
		ModelMapper mapper = new ModelMapper();
		plato = mapper.map(newPlato, Plato.class);
		plato = platoService.createPlato(plato);
		newPlato = mapper.map(plato, PlatoDTO.class);
		return newPlato;
	}


	@GetMapping("/listaPlatos")
	public List<PlatoDTO> getPlatos() {
		Iterable<Plato> platos = platoService.getPlatosL();
		List<PlatoDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		for (Plato plato : platos) {
			result.add(mapper.map(plato, PlatoDTO.class));
		}
		return result;
	}


	@GetMapping("/darPlatoXId/{idPlato}")
	public PlatoDTO getUsuarioById(@PathVariable Long idPlato){
		ModelMapper mapper = new ModelMapper();
		PlatoDTO plato = new PlatoDTO();
		Plato plat = new Plato();
		plat = platoService.getPlatoById(idPlato);
		plato = mapper.map(plat, PlatoDTO.class);
		return plato;
	}

	@GetMapping("/darPlatoXNombre/{nombrePlato}")
	public PlatoDTO getUsuarioById(@PathVariable String nombrePlato){
		ModelMapper mapper = new ModelMapper();
		PlatoDTO plato = new PlatoDTO();
		Plato plat = new Plato();
		plat = platoService.getPlatoByNombre(nombrePlato);
		plato = mapper.map(plat, PlatoDTO.class);
		return plato;
	}


	@PutMapping("/actualizarPlato/{idPlato}")
	public PlatoDTO actualizarPlato(@RequestBody PlatoDTO newPlato, @PathVariable Long idPlato){
		Plato plato = new Plato();
		ModelMapper mapper = new ModelMapper();
		plato = mapper.map(newPlato, Plato.class);
		plato = platoService.updatePlato(plato,idPlato);
		newPlato = mapper.map(plato, PlatoDTO.class);
		return newPlato;
	}


	@DeleteMapping("/eliminar/{idPlato}")
	public Boolean deletePlato(@PathVariable Long idPlato) {
		platoService.deletePlato(idPlato);
		return true;
	}

}
