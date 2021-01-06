package com.microservicios.configurarservidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurarServidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurarServidorApplication.class, args);
	}

}
