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
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<UsuarioDTO> getUsuarios(@RequestParam(name="page") int page, 
			@RequestParam(name="size", required = false, defaultValue = "10") int size) {
	
		Page<Usuario> usuarios = usuarioService.getUsuarios(PageRequest.of(page,size));
		List<UsuarioDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		
		for (Usuario usuario : usuarios) {
			result.add(mapper.map(usuario, UsuarioDTO.class));
		}

		return result;
		
	}


	//http://localhost:8080/darUsuario?idUsuario=14 

	//OJO> falta ver impresiones de los ERRORES!

	@GetMapping("/darUsuario")
	public UsuarioDTO getUsuarioById(@RequestParam(name = "idUsuario") Long idUsuario){
		ModelMapper mapper = new ModelMapper();
		UsuarioDTO usuario = new UsuarioDTO();
		Usuario usu = new Usuario();
		usu = usuarioService.getUsuarioById(idUsuario);
		usuario = mapper.map(usu, UsuarioDTO.class);
		return usuario;
	}


    @DeleteMapping("/eliminarUsuario")
	public String deleteUsuario(@RequestParam (name = "idUsuario") Long idUsuario) {
		Boolean res = usuarioService.deleteUsuario(idUsuario);
		if(res == true){
			return "Se elimino correctamente";
		}
		else{
			return "Se genero un error ";
		}
	}

    @PostMapping("/usuarios/crear")
	public Usuario createUsuario(@RequestBody Usuario nuevoUsuario) {
		return usuarioService.createUsuario(nuevoUsuario);
	}

	/*
	@PutMapping(value = "crear", consumes = MediaType.APPLICATION_XML_VALUE,
				produces = MediaType.APPLICATION_XML_VALUE)
	public Usuario crearUsuarioXML(@RequestBody Usuario nuevoUsuario){
		System.out.println("Creando un usuario");
		return usuarioService.createUsuario(nuevoUsuario);
	} */
    
}
