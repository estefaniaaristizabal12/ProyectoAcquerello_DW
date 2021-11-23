package com.desarrolloWeb.ProyectoAcquerello.security;

import java.util.Optional;

import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
    

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
	UsuarioRepository usuarioRepository;

	//public UsuarioDetailsServiceImpl(UsuarioRepository usuarioRepository) {
	//	this.usuarioRepository = usuarioRepository;
	//}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuarioOpt = usuarioRepository.findByIdUsuario(username);
        
		if (usuarioOpt == null) {
			throw new UsernameNotFoundException(username);
		}

		List<SimpleGrantedAuthority> authorities = getRoles(usuarioOpt);
 

		return new org.springframework.security.core.userdetails.User
		(usuarioOpt.get_email(), usuarioOpt.get_contrasenia(), authorities);
  

	}

    private List<SimpleGrantedAuthority> getRoles(Usuario usuarioOpt) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+usuarioOpt.get_rol()));
		return authorities;
	}

  
}

