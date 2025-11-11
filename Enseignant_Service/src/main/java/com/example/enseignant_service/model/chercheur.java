package com.example.enseignant_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class chercheur {
    private Integer id;
    private Integer numeroInscription;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Integer idEnseignant;

}
