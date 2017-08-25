package com.moli.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MainApplication {


	// swagger 接入
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
