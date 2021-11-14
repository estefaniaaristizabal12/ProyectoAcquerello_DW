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

            usuarioA.set_nombre("Juan");
			usuarioA.set_apellido("Bolaños");
			usuarioA.set_email("byjuanjobm1@gmail.com");
            usuarioA.set_contrasenia("12345");
            usuarioA.set_direccion("Calle 89 n122i 27");
			repository.save(usuarioA);

            // ___________ Usuario B _________________

            usuarioB.set_nombre("Estefania");
			usuarioB.set_apellido("Aristizabal");
			usuarioB.set_email("estefaniaAristi@gmail.com");
            usuarioB.set_contrasenia("12345");
            usuarioB.set_direccion("Calle Salitre 1 izqu");
			repository.save(usuarioB);


            Usuario usuario = new Usuario();
            for (int i = 3; i< 20; i++) {
				usuario = new Usuario();
				usuario.set_nombre("Usuario "+i);
				usuario.set_apellido("Apellido"+i);
				usuario.set_email("email"+i);
                usuario.set_contrasenia("contrasenia"+i);
                usuario.set_direccion("direccion"+i);
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


            carroCompras1.setUsuarioc(usuarioA);
            carroCompras1.setPlatoc(platoA);
            carroCompras1.set_cantidad(2);
            carroCompras1.set_precio(120000);
            carroCompras1.set_nombreProducto(platoA.get_nombre());
            carroCompras1.set_foto("assets/imagenVacia.png");
            repository.save(carroCompras1);
            

            // ___________ CarroCompras 2 _________________

            carroCompras2.setUsuarioc(usuarioA);
            carroCompras2.setPlatoc(platoB);
            carroCompras2.set_cantidad(1);
            carroCompras2.set_precio(50000);
            carroCompras2.set_nombreProducto(platoB.get_nombre());
            carroCompras2.set_foto("assets/imagenVacia.png");
            repository.save(carroCompras2);

            ;
            System.out.println("Carritos de Compras cargados de manera exitosa");

        };
    }
    /*
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
            //factura1.setFecha(calendar.getTime());
            repository.save(factura1);

            // ___________ Factura 2 _________________

            factura2.setPlato(platoB);
            factura2.setUsuario(usuarioA);
            factura2.setCantidad(1);
            factura2.setTotal(50000);
           // factura2.setFecha(calendar.getTime());
            repository.save(factura2);

            ;
            System.out.println("Carritos de Compras cargados de manera exitosa");

        };
    }*/
}
