package com.example.chercheurservice.feign;
import com.example.chercheurservice.config.FeignConfig;
import com.example.chercheurservice.model.enseignant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Enseignant-Service", url = "http://localhost:8085")
public interface EnseignantRestClient {
    @GetMapping("/enseignants/{id}")
    enseignant getEnseignantById(@PathVariable("id") Integer id);
}


