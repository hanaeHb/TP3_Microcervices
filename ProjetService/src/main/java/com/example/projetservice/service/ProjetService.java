package com.example.projetservice.service;

import com.example.projetservice.dto.RequestProjetDto;
import com.example.projetservice.dto.ResponseProjetDto;

import java.util.List;

public interface ProjetService {
    public ResponseProjetDto Add_Projet(RequestProjetDto requestProjetDto);
    public List<ResponseProjetDto> GETALLProjet();
    public ResponseProjetDto GETProjetById(Integer id);
    public ResponseProjetDto UPDATEProjet(Integer id , RequestProjetDto requestProjetDto);
    public void DELETEProjetBYID(Integer id);
    List<ResponseProjetDto> getProjetsByEnseignant(Integer idEnseignant);
}
