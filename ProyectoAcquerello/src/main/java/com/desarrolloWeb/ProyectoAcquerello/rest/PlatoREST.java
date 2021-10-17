package com.desarrolloWeb.ProyectoAcquerello.rest;



import java.util.ArrayList;
import java.util.List;

import com.desarrolloWeb.ProyectoAcquerello.dtos.PlatoDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.servicio.IPlatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;


@RestController
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
    
    @PostMapping("/platos/crear")
	public Plato crearPlato(@RequestBody Plato newPlato) {
		return platoService.crearPlato(newPlato);
	}


    @PutMapping("/platos/actualizar/{id}")
	public Plato actualizarPlato(@RequestBody Plato newPlato, @PathVariable Long id) {
		return platoService.actualizarPlato(newPlato, id);
	}


    @DeleteMapping("/platos/eliminar/{id}")
	public void deletePlato(@PathVariable Long id) {
		platoService.deletePlato(id);
	}
	

    /*
    @GetMapping("/platos/consultar/{idPlato}")
	public Plato getPlatoById(@PathVariable Long idPlato) {
		return platoService.getPlatoById(idPlato);
	}
    */

}
