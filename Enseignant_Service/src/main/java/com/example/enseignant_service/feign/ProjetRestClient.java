package com.example.enseignant_service.feign;

import com.example.enseignant_service.config.FeignConfig;
import com.example.enseignant_service.model.projet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Projet-Service", url = "http://localhost:8087", configuration = FeignConfig.class)
public interface ProjetRestClient {
    @GetMapping("/v1/projets/enseignant/{idEnseignant}")
    List<projet> getProjetsByEnseignant(@PathVariable("idEnseignant") Integer enseignantId);
}
