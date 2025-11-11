package com.example.enseignant_service.dto;

public class ResponseStatsDto {

    private Integer nbChercheurs;
    private Integer nbProjets;



    public ResponseStatsDto(Integer nbChercheurs, Integer nbProjets) {
        this.nbChercheurs = nbChercheurs;
        this.nbProjets = nbProjets;
    }

    public Integer getNbChercheurs() {
        return nbChercheurs;
    }
    public void setNbChercheurs(Integer nbChercheurs) {
        this.nbChercheurs = nbChercheurs;
    }
    public Integer getNbProjets() {
        return nbProjets;
    }
    public void setNbProjets(Integer nbProjets) {
        this.nbProjets = nbProjets;
    }
}

