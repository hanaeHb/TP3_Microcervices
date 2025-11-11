package com.example.chercheurservice.repository;

import com.example.chercheurservice.entity.chercheur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ChercheurRepository extends JpaRepository<chercheur, Integer> {
    List<chercheur> findByIdEnseignant(Integer idEnseignant);
    List<chercheur> findByIdProjet(Integer idProjet);

}
