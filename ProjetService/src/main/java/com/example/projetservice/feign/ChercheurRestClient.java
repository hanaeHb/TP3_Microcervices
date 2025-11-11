package com.example.projetservice.feign;

import com.example.projetservice.config.FeignConfig;
import com.example.projetservice.model.chercheur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CHERCHEUR-SERVICE", url = "http://localhost:8086/v1/chercheurs", configuration = FeignConfig.class)
public interface ChercheurRestClient {

    @GetMapping("/{id}")
    chercheur getChercheurById(@PathVariable("id") Integer id);
}
