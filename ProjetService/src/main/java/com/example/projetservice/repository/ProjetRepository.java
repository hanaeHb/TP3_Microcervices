package com.example.projetservice.repository;

import com.example.projetservice.entity.projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepository extends JpaRepository<projet, Integer> {
    List<projet> findByIdEnseignant(Integer idEnseignant);

    List<projet> findByIdChercheur(Integer idChercheur);
}
