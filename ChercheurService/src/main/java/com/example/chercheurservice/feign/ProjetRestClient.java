package com.example.chercheurservice.feign;


import com.example.chercheurservice.config.FeignConfig;
import com.example.chercheurservice.model.projet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROJET-SERVICE", url = "http://localhost:8087", configuration = FeignConfig.class)
public interface ProjetRestClient {
    @GetMapping("/{id}")
    projet getProjetById(@PathVariable("id") Integer id);
}
