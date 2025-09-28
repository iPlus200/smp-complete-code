package com.example.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Management System")
                        .description("A simple project with Thymeleaf + Spring Boot")
                        .version("2.1.4"));
    }
}
