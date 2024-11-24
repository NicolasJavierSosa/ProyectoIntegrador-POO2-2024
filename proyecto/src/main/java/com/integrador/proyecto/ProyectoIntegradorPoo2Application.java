package com.integrador.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "modelo")
public class ProyectoIntegradorPoo2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoIntegradorPoo2Application.class, args);
	}

}
