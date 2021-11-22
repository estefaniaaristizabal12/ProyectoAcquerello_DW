package com.desarrolloWeb.ProyectoAcquerello.rest;
import com.desarrolloWeb.ProyectoAcquerello.servicio.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;
import com.desarrolloWeb.ProyectoAcquerello.dtos.UsuarioDTO;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("usuario")
public class UsuarioREST {

    @Autowired
	private IUsuarioService usuarioService;

    // - - - - - - - -  C   R   U  D  - - - - - - - - 



	@PostMapping("/crear")
	public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO newUsuario) {
		Usuario usuario = new Usuario();
		ModelMapper mapper = new ModelMapper();
		usuario = mapper.map(newUsuario, Usuario.class);
		usuario = usuarioService.createUsuario(usuario);
		newUsuario = mapper.map(usuario, UsuarioDTO.class);
		return newUsuario;
	}


	@GetMapping("/listaUsuarios")
	public List<UsuarioDTO> getUsuarios() {
		Iterable<Usuario> usuarios = usuarioService.getUsuariosLista();
		List<UsuarioDTO> result = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		for (Usuario usuario : usuarios) {
			result.add(mapper.map(usuario, UsuarioDTO.class));
		}
		return result;
	}



	@GetMapping("/darUsuarioXId/{idUsuario}")
	public UsuarioDTO getUsuarioById(@PathVariable Long idUsuario){
		ModelMapper mapper = new ModelMapper();
		UsuarioDTO usuario = new UsuarioDTO();
		Usuario usu = new Usuario();
		usu = usuarioService.getUsuarioById(idUsuario);
		usuario = mapper.map(usu, UsuarioDTO.class);
		return usuario;
	}

	@GetMapping("/darUsuarioXEmail/{emailUsuario}")
	public UsuarioDTO getUsuarioById(@PathVariable String emailUsuario){
		ModelMapper mapper = new ModelMapper();
		UsuarioDTO usuario = new UsuarioDTO();
		Usuario usu = new Usuario();
		usu = usuarioService.getUsuarioByEmail(emailUsuario);
		usuario = mapper.map(usu, UsuarioDTO.class);
		return usuario;
	}


	@PutMapping("/actualizarUsuario/{idUsuario}")
	public UsuarioDTO actualizarUsuario(@RequestBody UsuarioDTO newUsuario, @PathVariable Long idUsuario){
		Usuario usuario = new Usuario();
		ModelMapper mapper = new ModelMapper();
		usuario = mapper.map(newUsuario, Usuario.class);
		usuario = usuarioService.updateUsuario(usuario,idUsuario);
		newUsuario = mapper.map(usuario, UsuarioDTO.class);
		return newUsuario;
	}



    // @DeleteMapping("/eliminarUsuario")
	// public String deleteUsuario(@RequestParam (name = "email") String email) {
	// 	Boolean res = usuarioService.deleteUsuario(email);
	// 	if(res == true){
	// 		return "Se elimino correctamente";
	// 	}
	// 	else{
	// 		return "Se genero un error ";
	// 	}
	// }


}
