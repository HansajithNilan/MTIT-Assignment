package com.example.courseservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI courseServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Course Service API")
                        .description("Microservice for managing course data in the School Management System")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("School Management System")
                                .email("admin@example.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation"));
    }
}
