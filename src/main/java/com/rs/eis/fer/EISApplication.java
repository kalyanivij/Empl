package com.rs.eis.fer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EISApplication {

	public static void main(String[] args) {
		SpringApplication.run(EISApplication.class, args);
	}
	
}
