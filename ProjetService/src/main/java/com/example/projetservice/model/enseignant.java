package com.example.projetservice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class enseignant {
    private Integer id;

    private String nom;
    private String prenom;
    private String cne;
    private String email;
    private String motDePasse;
    private String thematiqueRecherche;
}
