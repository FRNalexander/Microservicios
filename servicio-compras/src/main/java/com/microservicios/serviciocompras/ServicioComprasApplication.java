package com.microservicios.serviciocompras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioComprasApplication.class, args);
	}

}
