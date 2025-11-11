package com.example.chercheurservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestChercheurDto {

    private Integer numeroInscription;
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
