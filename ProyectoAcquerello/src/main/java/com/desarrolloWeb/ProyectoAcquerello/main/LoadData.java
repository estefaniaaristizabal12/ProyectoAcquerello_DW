package com.desarrolloWeb.ProyectoAcquerello.main;
import org.springframework.context.annotation.Configuration;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
class LoadData {

    @Bean
	CommandLineRunner initDataUsuarios(UsuarioRepository repository) {
        return args -> {
			System.out.println("Cargando Usuarios en la Base de Datos");
            Usuario usuario = new Usuario();
            for (int i = 3; i< 20; i++) {
				usuario = new Usuario();
				usuario.setNombre("Usuario "+i);
				usuario.setApellido("Apellido"+i);
				usuario.setEmail("email"+i);
                usuario.setContrasenia("contrasenia"+i);
                usuario.setDireccion("direccion"+i);
				repository.save(usuario);
			}

            System.out.println("Usuarios cargados de manera exitosa");

        };

    }
    
}