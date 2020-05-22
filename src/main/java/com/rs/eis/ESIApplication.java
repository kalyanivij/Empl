package com.rs.eis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ESIApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESIApplication.class, args);
	}
	
}
