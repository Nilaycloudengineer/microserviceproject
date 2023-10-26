package com.lulu.Lulu02_recap_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Lulu02RecapApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lulu02RecapApiApplication.class, args);
	}

}
