package com.example.projetservice.repository;

import com.example.projetservice.entity.projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<projet, Integer> {
}
