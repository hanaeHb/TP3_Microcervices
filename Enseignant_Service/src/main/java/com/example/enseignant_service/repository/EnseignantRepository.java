package com.example.enseignant_service.repository;

import com.example.enseignant_service.entity.enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<enseignant, Integer> {
}
