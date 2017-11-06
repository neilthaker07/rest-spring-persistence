package edu.sjsu.cmpe275.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "edu.sjsu.cmpe275.rest")
@SpringBootApplication
public class Minigame2Application {

	public static void main(String[] args) {
		SpringApplication.run(Minigame2Application.class, args);
	}
}
