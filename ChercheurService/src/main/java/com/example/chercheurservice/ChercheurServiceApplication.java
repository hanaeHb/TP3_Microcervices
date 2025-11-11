package com.example.chercheurservice;

import com.example.chercheurservice.config.RsaKeys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(RsaKeys.class)
public class ChercheurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChercheurServiceApplication.class, args);
    }

}
