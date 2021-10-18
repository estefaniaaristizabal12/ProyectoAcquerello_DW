package com.desarrolloWeb.ProyectoAcquerello.main;
import org.springframework.context.annotation.Configuration;

import com.desarrolloWeb.ProyectoAcquerello.modelo.CarroCompras;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Factura;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Plato;
import com.desarrolloWeb.ProyectoAcquerello.modelo.Usuario;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.CarroComprasRepository;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.FacturaRepository;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.PlatoRepository;
import com.desarrolloWeb.ProyectoAcquerello.repositorio.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
class LoadData {

    
    Usuario usuarioA = new Usuario();
    Usuario usuarioB = new Usuario();

    Plato platoA = new Plato();
    Plato platoB = new Plato();

    CarroCompras carroCompras1 = new CarroCompras();
    CarroCompras carroCompras2 = new CarroCompras();

    Factura factura1 = new Factura();
    Factura factura2 = new Factura();

    @Bean
	CommandLineRunner initDataUsuarios(UsuarioRepository repository) {
        return args -> {
			System.out.println("Cargando Usuarios en la Base de Datos");

            // ___________ Usuario A _________________

            usuarioA.setNombre("Juan");
			usuarioA.setApellido("Bolaños");
			usuarioA.setEmail("byjuanjobm1@gmail.com");
            usuarioA.setContrasenia("12345");
            usuarioA.setDireccion("Calle 89 n122i 27");
			repository.save(usuarioA);

            // ___________ Usuario B _________________

            usuarioA.setNombre("Estefania");
			usuarioA.setApellido("Aristizabal");
			usuarioA.setEmail("estefaniaAristi@gmail.com");
            usuarioA.setContrasenia("12345");
            usuarioA.setDireccion("Calle Salitre 1 izqu");
			repository.save(usuarioB);


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

    @Bean
	CommandLineRunner initDataPlatos(PlatoRepository repository) {
        return args -> {
	        System.out.println("Cargando Usuarios en la Base de Datos");

                    // ___________ Plato 1 _________________

            platoA.setNombre("Pasta Al Pomodoro Fresco");
            platoA.setDescripcion("Clasica pasta con albahaca y aceite de oliva");
            platoA.setPrecio(19000);
            repository.save(platoA);

                    // ___________ Plato 2 _________________

            platoB.setNombre("Pasta Al Funghi");
            platoB.setDescripcion("Salsa cremosa de hongos con adicion de especies");
            platoB.setPrecio(21000);
            repository.save(platoB);


            Plato plato = new Plato();
            for (int i = 3; i< 20; i++) {
				plato = new Plato();
				plato.setNombre("Plato "+i);
				plato.setDescripcion("descripcion"+i);
				plato.setPrecio(100);
				repository.save(plato);
			}
            System.out.println("Platos cargados de manera exitosa");
        };
    }

    @Bean
    CommandLineRunner initDataCarroCompras(CarroComprasRepository repository) {

        return args -> {

            System.out.println("Cargando Carrritos de compras en la Base de Datos");
            
            // ___________ CarroCompras 1 _________________


            carroCompras1.setUsuario(usuarioA);
            carroCompras1.setPlato(platoA);
            carroCompras1.setCantidad(2);
            carroCompras1.setPrecio(105000);
            repository.save(carroCompras1);
            

            // ___________ CarroCompras 2 _________________

            carroCompras1.setUsuario(usuarioA);
            carroCompras1.setPlato(platoB);
            carroCompras1.setCantidad(1);
            carroCompras1.setPrecio(50000);
            repository.save(carroCompras2);

            ;
            System.out.println("Carritos de Compras cargados de manera exitosa");

        };
    }
    
    @Bean
    CommandLineRunner initDataFactura(FacturaRepository repository) {

        return args -> {

            System.out.println("Cargando Facturas en la Base de Datos");
            
            // ___________ Factura 1 _________________


            factura1.setPlato(platoA);
            factura1.setUsuario(usuarioA);
            factura1.setCantidad(2);
            factura1.setTotal(105000);
            repository.save(factura1);

            // ___________ Factura 2 _________________

            factura2.setPlato(platoB);
            factura2.setUsuario(usuarioA);
            factura2.setCantidad(1);
            factura2.setTotal(50000);
            repository.save(factura2);

            ;
            System.out.println("Carritos de Compras cargados de manera exitosa");

        };
    }
}
