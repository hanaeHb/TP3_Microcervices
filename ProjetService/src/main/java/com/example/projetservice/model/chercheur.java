package com.example.projetservice.model;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class chercheur {
    private Integer id;
    private Integer numeroInscription;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Integer idEnseignant;
    private Integer idProjet;
}
