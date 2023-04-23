package com.ConfigServerRPS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerRpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerRpsApplication.class, args);
	}

}
