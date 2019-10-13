package com.configserver.ems.emsconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EmsConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsConfigserverApplication.class, args);
	}

}
