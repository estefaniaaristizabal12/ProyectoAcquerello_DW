package com.desarrolloWeb.ProyectoAcquerello.main;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

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

            usuarioB.setNombre("Estefania");
			usuarioB.setApellido("Aristizabal");
			usuarioB.setEmail("estefaniaAristi@gmail.com");
            usuarioB.setContrasenia("12345");
            usuarioB.setDireccion("Calle Salitre 1 izqu");
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

            platoA.set_nombre("Pasta Al Pomodoro Fresco");
            platoA.set_descripcion("Clasica pasta con albahaca y aceite de oliva");
            platoA.set_precio(19000);
            platoA.set_imagen("assets/imagenVacia.png");
            repository.save(platoA);

                    // ___________ Plato 2 _________________

            platoB.set_nombre("Pasta Al Funghi");
            platoB.set_descripcion("Salsa cremosa de hongos con adicion de especies");
            platoB.set_precio(19000);
            platoB.set_imagen("assets/imagenVacia.png");
            repository.save(platoB);


            Plato plato = new Plato();
            for (int i = 3; i< 20; i++) {
				plato = new Plato();
				plato.set_nombre("Plato "+i);
				plato.set_descripcion("descripcion"+i);
				plato.set_precio(100);
                plato.set_imagen("assets/imagenVacia.png");
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

            carroCompras2.setUsuario(usuarioA);
            carroCompras2.setPlato(platoB);
            carroCompras2.setCantidad(1);
            carroCompras2.setPrecio(50000);
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
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 1899);
            calendar.set(Calendar.DAY_OF_MONTH, 11);
            calendar.set(Calendar.MONTH, 10);
            calendar.set(Calendar.HOUR, 6);
            
            factura1.setPlato(platoA);
            factura1.setUsuario(usuarioA);
            factura1.setCantidad(2);
            factura1.setTotal(105000);
            factura1.setFecha(calendar.getTime());
            repository.save(factura1);

            // ___________ Factura 2 _________________

            factura2.setPlato(platoB);
            factura2.setUsuario(usuarioA);
            factura2.setCantidad(1);
            factura2.setTotal(50000);
            factura2.setFecha(calendar.getTime());
            repository.save(factura2);

            ;
            System.out.println("Carritos de Compras cargados de manera exitosa");

        };
    }
}
