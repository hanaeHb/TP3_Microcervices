package com.example.enseignant_service.feign;

import com.example.enseignant_service.config.FeignConfig;
import com.example.enseignant_service.model.chercheur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Chercheur-Service", url = "http://localhost:8086", configuration = FeignConfig.class)
public interface ChercheurRestClient {

    @GetMapping("/v1/chercheurs/enseignant/{id}")
    List<chercheur> getChercheursByEnseignant(@PathVariable("id") Integer idEnseignant);
}
