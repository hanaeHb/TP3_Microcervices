package com.example.chercheurservice.repository;

import com.example.chercheurservice.entity.chercheur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChercheurRepository extends JpaRepository<chercheur, Integer> {
}
