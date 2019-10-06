package com.ems.projectsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class ProjectsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsServiceApplication.class, args);
	}

}
