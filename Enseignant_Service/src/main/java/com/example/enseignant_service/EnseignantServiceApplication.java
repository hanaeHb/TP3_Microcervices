package com.example.enseignant_service;

import com.example.enseignant_service.config.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeys.class)
public class EnseignantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnseignantServiceApplication.class, args);
    }

}
