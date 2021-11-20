package com.desarrolloWeb.ProyectoAcquerello.rest;



import java.util.ArrayList;
import java.util.List;

import com.desarrolloWeb.ProyectoAcquerello.dtos.PlatoDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.servicio.IPlatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("plato")
public class PlatoREST {

    @Autowired
	private IPlatoService platoService;

    
    private List<PlatoDTO> convertDTOs(Page<Plato> platos) {
		List<PlatoDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Plato plato : platos) {
			result.add(mapper.map(plato, PlatoDTO.class));
		}
		
		return result;
	}

	@PostMapping("/crear")
	public Plato crearPlato(@RequestBody Plato newPlato) {
		return platoService.createPlato(newPlato);
	}

	//http://localhost:8080/plato/listaPlatosEst

	@GetMapping("/listaPlatosEst")
	public List<PlatoDTO> getPlatos() {

		Iterable<Plato> platos = platoService.getPlatosL();
		List<PlatoDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Plato plato : platos) {
			result.add(mapper.map(plato, PlatoDTO.class));
		}

		return result;
	}


	//http://localhost:8080/darPlato?idUPlato=14 

	//OJO-- falta ver impresiones de los ERRORES!
	@GetMapping("/darPlato")
	public PlatoDTO getPlatoById(@RequestParam(name = "idPlato") Long idPlato){
		ModelMapper mapper = new ModelMapper();
		PlatoDTO plato = new PlatoDTO();
		Plato plat = new Plato();
		plat = platoService.getPlatoById(idPlato);
		plato = mapper.map(plat, PlatoDTO.class);
		return plato;
	}


	// @PutMapping("/equipos/actualizar/{id}")
	// public Equipo actualizarEquipo(@RequestBody Equipo newEquipo, @PathVariable Long id) {
	// 	return equipoService.actualizarEquipo(newEquipo, id);
	// }


	@PutMapping("/actualizarPlato/{idPlato}")
	public Plato actualizarPlato(@RequestBody PlatoDTO newPlato) {
		Plato plato = new Plato();
		ModelMapper mapper = new ModelMapper();
		plato = mapper.map(newPlato, Plato.class);
		return platoService.updatePlato(plato);
	}




    // @PostMapping("/actualizarPlato")
	// public Plato actualizarPlato(@RequestBody PlatoDTO newPlato) {
	// 	Plato plato = new Plato();
	// 	ModelMapper mapper = new ModelMapper();
	// 	plato = mapper.map(newPlato, Plato.class);
	// 	return platoService.updatePlato(plato);
	// }


    @DeleteMapping("/eliminar/{idPlato}")
	public void deletePlato(@PathVariable String id) {
		System.out.println("MIRAAA ESTEFANIA"+id);
		platoService.deletePlato(Long.valueOf(id));
	}
	

}
