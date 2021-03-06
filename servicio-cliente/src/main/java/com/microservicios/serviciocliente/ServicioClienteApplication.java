package com.microservicios.serviciocliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioClienteApplication.class, args);
	}

}
