package com.desarrolloWeb.ProyectoAcquerello.rest;

import com.desarrolloWeb.ProyectoAcquerello.servicio.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import com.desarrolloWeb.ProyectoAcquerello.dtos.UsuarioDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.solr.core.query.SolrPageRequest;



@RestController
public class UsuarioREST {

    @Autowired
	private IUsuarioService usuarioService;

    private List<UsuarioDTO> convertirDTOs(Page<Usuario> usuarios) {
		List<UsuarioDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Usuario usuario : usuarios) {
			result.add(mapper.map(usuario, UsuarioDTO.class));
		}
		
		return result;
	}


	//http://localhost:8080/usuarios/listarUsuarios?page=1
	@GetMapping("/usuarios/listarUsuarios")
	public List<UsuarioDTO> getEquipos(@RequestParam(name="page") int page, 
			@RequestParam(name="size", required = false, defaultValue = "10") int size) {
	
		Page<Usuario> usuarios = usuarioService.getUsuarios(PageRequest.of(page,size));
		List<UsuarioDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Usuario usuario : usuarios) {
			result.add(mapper.map(usuario, UsuarioDTO.class));
		}

		return result;
		
	}

	/*
	
	@GetMapping("/usuarios/listar/{page}/{size}")
	public Page<UsuarioDTO> getEquipos(@PathVariable("page") int pagina, @PathVariable("size") int size) {
		Pageable pageable = new SolrPageRequest(pagina, size, Sort.by(Direction.ASC, "id"));
		Page<Usuario> usuarios = usuarioService.getUsuarios(pageable);
		
		List<UsuarioDTO> result = convertirDTOs(usuarios);
		
		return new PageImpl<>(result, pageable, usuarios.getTotalElements());
	}*/
	

    @DeleteMapping("/usuarios/eliminar/{id}")
	public void deleteUsuario(@PathVariable Long idUsuario) {
		usuarioService.deleteUsuario(idUsuario);
	}

    @PostMapping("/usuarios/crear")
	public Usuario createUsuario(@RequestBody Usuario nuevoUsuario) {
		return usuarioService.createUsuario(nuevoUsuario);
	}

	@PutMapping(value = "crear", consumes = MediaType.APPLICATION_XML_VALUE,
				produces = MediaType.APPLICATION_XML_VALUE)
	public Usuario crearUsuarioXML(@RequestBody Usuario nuevoUsuario){
		System.out.println("Creando un usuario");
		return usuarioService.createUsuario(nuevoUsuario);
	}
    
}
