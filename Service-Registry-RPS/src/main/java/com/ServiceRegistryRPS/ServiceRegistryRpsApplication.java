package com.ServiceRegistryRPS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryRpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryRpsApplication.class, args);
	}

}
