package com.example.projetservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestProjetDto {
    private String titre;
    private String description;
    private Integer idEnseignant;
    private Integer idChercheur;

}
