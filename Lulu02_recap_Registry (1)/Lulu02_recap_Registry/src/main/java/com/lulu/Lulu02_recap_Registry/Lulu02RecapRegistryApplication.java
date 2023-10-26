package com.lulu.Lulu02_recap_Registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lulu02RecapRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lulu02RecapRegistryApplication.class, args);
	}

}
