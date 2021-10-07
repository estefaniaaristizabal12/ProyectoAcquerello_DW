package com.desarrolloWeb.ProyectoAcquerello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProyectoAcquerelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoAcquerelloApplication.class, args);
	}

}
