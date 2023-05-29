package com.nodoapi.nodoapi;

import com.nodoapi.nodoapi.persistence.entity.Rol;
import com.nodoapi.nodoapi.persistence.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NodoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NodoApiApplication.class, args);
	}

}
