package com.example.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swagger {

    @Bean
    public OpenAPI customOpenAPI() {

        Contact contacto = new Contact();
        contacto.setName("Sebastian Jeremias Flores Fuertes");
        contacto.setUrl("Universidad Autónoma Tomás Frías");

        return new OpenAPI()

                .info(new Info()
                        .title("API REST - Examen final")
                        .version("1.0")
                        .description(
                                "Examen final - Backend Spring Boot\n\n" +
                                        "Tecnologías Emergentes\n\n" +
                                        "CRUD completo del Colegio Carlos Medinaceli utilizando Spring Boot, PostgreSQL y Swagger.")
                        .contact(contacto)
                        .license(
                                new License()
                                        .name("Universidad Autónoma Tomás Frías")))

                .externalDocs(
                        new ExternalDocumentation()
                                .description("Tecnologías Emergentes - SIS 414"));
    }
}