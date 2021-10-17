package com.desarrolloWeb.ProyectoAcquerello.rest;

import com.desarrolloWeb.ProyectoAcquerello.servicio.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import com.desarrolloWeb.ProyectoAcquerello.dtos.UsuarioDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.modelmapper.ModelMapper;

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

    @DeleteMapping("/usuarios/eliminar/{id}")
	public void deleteUsuario(@PathVariable Long idUsuario) {
		usuarioService.deleteUsuario(idUsuario);
	}

    @PostMapping("/usuarios/crear")
	public Usuario createUsuario(@RequestBody Usuario nuevoUsuario) {
		return usuarioService.createUsuario(nuevoUsuario);
	}
    
}
