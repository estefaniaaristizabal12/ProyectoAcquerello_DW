package com.desarrolloWeb.ProyectoAcquerello.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.desarrolloWeb.ProyectoAcquerello")
@EntityScan("com.desarrolloWeb.ProyectoAcquerello")
@EnableJpaRepositories("com.desarrolloWeb.ProyectoAcquerello")
@EnableAutoConfiguration

public class ProyectoAcquerelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoAcquerelloApplication.class, args);
	}

}
