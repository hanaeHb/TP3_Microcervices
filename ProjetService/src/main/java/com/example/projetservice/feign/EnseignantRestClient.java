package com.example.projetservice.feign;

import com.example.projetservice.config.FeignConfig;
import com.example.projetservice.model.enseignant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ENSEIGNANT-SERVICE", url = "http://localhost:8085/v1/enseignants", configuration = FeignConfig.class)
public interface EnseignantRestClient {
    @GetMapping("/api/enseignants/{id}")
    enseignant getEnseignantById(@PathVariable("id") Integer id);
}
