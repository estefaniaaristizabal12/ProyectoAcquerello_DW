package com.desarrolloWeb.ProyectoAcquerello.main;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	CommandLineRunner initDataUsuarios(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
			System.out.println("Cargando Usuarios en la Base de Datos");

           

            // ____ Usuario A ______

            usuarioA.set_nombre("Juan");
			usuarioA.set_apellido("Bolaños");
			usuarioA.set_email("byjuanjobm1@gmail.com");
            usuarioA.set_contrasenia(passwordEncoder.encode("12345"));
            usuarioA.set_direccion("Calle 89 n122i 27");
            usuarioA.set_rol("administrador");

			repository.save(usuarioA);

            // ____ Usuario B ______

            usuarioB.set_nombre("Estefania");
			usuarioB.set_apellido("Aristizabal");
			usuarioB.set_email("estefaniaAristi@gmail.com");
            usuarioB.set_contrasenia(passwordEncoder.encode("12345"));
            usuarioB.set_direccion("Calle Salitre 1 izqu");
            usuarioB.set_rol("usuario");
			repository.save(usuarioB);

            Usuario usuario = new Usuario();
            for (int i = 3; i< 10; i++) {
				usuario = new Usuario();
				usuario.set_nombre("Usuario "+i);
				usuario.set_apellido("Apellido"+i);
				usuario.set_email("email"+i);
                usuario.set_contrasenia("contrasenia"+i);
                usuario.set_direccion("direccion"+i);
                usuario.set_rol("usuario");
				repository.save(usuario);
			}
            System.out.println("Usuarios cargados de manera exitosa");
        };

    }

    @Bean
	CommandLineRunner initDataPlatos(PlatoRepository repository) {
        return args -> {
	        System.out.println("Cargando Platos en la Base de Datos");

            


            //------ Pizza -------
            Plato plato1 = new Plato();
            plato1.set_nombre("Pizza Burrata");
            plato1.set_descripcion("Burrata fresca de búfala, parmigiano y pimienta.");
            plato1.set_precio(39900);
            plato1.set_imagen("assets/pizzaBurrata.png");
            repository.save(plato1);

            Plato plato2 = new Plato();
            plato2.set_nombre("Pizza Pepperoni");
            plato2.set_descripcion("Chorizo italiano, queso mozzarella y pimienta");
            plato2.set_precio(33900);
            plato2.set_imagen("assets/pizzaPepperoni.png");
            repository.save(plato2);

            Plato plato3 = new Plato();
            plato3.set_nombre("Pizza Italiana");
            plato3.set_descripcion("Salsiccia sicilina, jamón artesanal, pepperoni y queso.");
            plato3.set_precio(33900);
            plato3.set_imagen("assets/pizzaItaliana.png");
            repository.save(plato3);

            //------ Ensalada -------
            Plato plato4 = new Plato();
            plato4.set_nombre("Ensalada de la casa");
            plato4.set_descripcion("Pollo a la parilla, tocineta crujiente, tomate cherry y habichuela");
            plato4.set_precio(33900);
            plato4.set_imagen("assets/ensaladaCasa.png");
            repository.save(plato4);

            Plato plato5 = new Plato();
            plato5.set_nombre("Ensalada césar");
            plato5.set_descripcion("Pollo a la parrilla, lechuga romana, crutones y parmigiano");
            plato5.set_precio(33900);
            plato5.set_imagen("assets/ensaladaCesar.png");
            repository.save(plato5);

            Plato plato6 = new Plato();
            plato6.set_nombre("Panino pollo rostizado");
            plato6.set_descripcion("Jugoso pollo rostizado, lechuga, tomate y tocineta");
            plato6.set_precio(33900);
            plato6.set_imagen("assets/paninoPolloRostizado.png");
            repository.save(plato6);


            //  -------  Pasta ---------
            Plato plato7 = new Plato();
            plato7.set_nombre("Pasta al pomodoro fresco");
            plato7.set_descripcion("Nuestra clásica salsa de tomate, albahaca y aceite de oliva.");
            plato7.set_precio(27900);
            plato7.set_imagen("assets/pastaPomodoro.png");
            repository.save(plato7);

            Plato plato8 = new Plato();
            plato8.set_nombre("Pasta al Funghi");
            plato8.set_descripcion("Salsa cremosa de hongos y parmigiano.");
            plato8.set_precio(30900);
            plato8.set_imagen("assets/pastaAlFunghi.png");
            repository.save(plato8);

            Plato plato9 = new Plato();
            plato9.set_nombre("Pasta al Ragú de res");
            plato9.set_descripcion("Suculento ragú de res en nuestra salsa pomodoro");
            plato9.set_precio(35900);
            plato9.set_imagen("assets/pastaAlRagu.png");
            repository.save(plato9);


             // ____ Plato 1 ______

            platoA.set_nombre("Risotto Di Mare");
            platoA.set_descripcion("Arroz arbóreo, pescado blanco y camarones.");
            platoA.set_precio(49900);
            platoA.set_imagen("assets/risottoDiMare.png");
            repository.save(platoA);

            // ____ Plato 2 ______

            platoB.set_nombre("Risotto Al Funghi");
            platoB.set_descripcion("Arroz arbóreo, cremosa salsa de hongos y parmigiano.");
            platoB.set_precio(39000);
            platoB.set_imagen("assets/risottoAlFunghi.png");
            repository.save(platoB);


            System.out.println("Platos cargados de manera exitosa");
        };
    }

    @Bean
    CommandLineRunner initDataCarroCompras(CarroComprasRepository repository) {

        return args -> {

            System.out.println("Cargando Carrritos de compras en la Base de Datos");
            
            // ____ CarroCompras 1 ______

            carroCompras1.setUsuarioc(usuarioB);
            carroCompras1.setPlatoc(platoA);
            carroCompras1.set_cantidad(2);
            carroCompras1.set_precio(120000);
            carroCompras1.set_nombreProducto(platoA.get_nombre());
            carroCompras1.set_foto("assets/imagenVacia.png");
            repository.save(carroCompras1);
            

            // ____ CarroCompras 2 ______

            carroCompras2.setUsuarioc(usuarioB);
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
    
    @Bean
    CommandLineRunner initDataFactura(FacturaRepository repository) {

        return args -> {

            System.out.println("Cargando Facturas en la Base de Datos");
            
            // ____ Factura 1 ______
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 1899);
            calendar.set(Calendar.DAY_OF_MONTH, 11);
            calendar.set(Calendar.MONTH, 10);
            calendar.set(Calendar.HOUR, 6);
            
            factura1.setPlatof(platoB);
            factura1.setUsuariof(usuarioA);
            factura1.setCantidad(2);
            factura1.setTotal(105000);
            factura1.setFecha(calendar.getTime());
            factura1.setFoto("assets/imagenVacia.png");
            repository.save(factura1);

            // ____ Factura 2 ______

            factura2.setPlatof(platoA);
            factura2.setUsuariof(usuarioA);
            factura2.setCantidad(1);
            factura2.setTotal(50000);
            factura2.setFecha(calendar.getTime());
            factura2.setFoto("assets/imagenVacia.png");
            repository.save(factura2);

            ;
            System.out.println("Carritos de Compras cargados de manera exitosa");

        };
    }
}