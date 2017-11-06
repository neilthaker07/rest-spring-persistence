package edu.sjsu.cmpe275.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.sjsu.cmpe275.controllers","edu.sjsu.cmpe275.services"})
//@EnableJpaRepositories("edu.sjsu.cmpe275.rest")
@EntityScan("edu.sjsu.cmpe275.rest")
//@EnableJpaRepositories(basePackages = {"edu.sjsu.cmpe275.rest","\"org.bluedolphin.spring.data.mysql\""})
//@EnableAutoConfiguration (exclude = { DataSourceAutoConfiguration.class })
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MinigameApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinigameApplication.class, args);
	}
}
