package com.example.enseignant_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class projet {
    private Integer id;
    private String titre;
    private String description;
    private Integer idEnseignant;
    private Integer idChercheur;
}
