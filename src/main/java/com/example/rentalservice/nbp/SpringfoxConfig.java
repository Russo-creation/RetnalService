package com.example.rentalservice.nbp;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

public class SpringfoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());

    }

    private ApiInfo getApiInfo(){
        return new ApiInfo(
                "Nbp Service REst API",
                "Rest API for NBP AVR",
                "PJK 1.0",
                null,
                new Contact("PJATK", "www.gdansk.pl", "dziekantat@pjwstk.edu.pl"),
                "licence",
                "www.google.pl",
                Collections.emptyList()
        );
    }
}
