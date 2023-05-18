package com.fs.service.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.fs.service.*")
@EnableJpaRepositories("com.fs.service.auth.repository")
@EntityScan("com.fs.service.auth.repository.models")
public class UserAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserAuthApplication.class, args);
	}
}
