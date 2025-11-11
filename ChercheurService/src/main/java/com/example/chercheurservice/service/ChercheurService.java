package com.example.chercheurservice.service;

import com.example.chercheurservice.dto.RequestChercheurDto;
import com.example.chercheurservice.dto.ResponseChercheurDto;

import java.util.List;
import java.util.Map;

public interface ChercheurService {
    public ResponseChercheurDto Add_Chercheur(RequestChercheurDto requestChercheurDto);
    public List<ResponseChercheurDto> GETALLChercheur();
    public ResponseChercheurDto GETChercheurById(Integer id);
    public ResponseChercheurDto UPDATEChercheur(Integer id , RequestChercheurDto requestChercheurDto);
    public void DELETEChercheurBYID(Integer id);
    List<ResponseChercheurDto> getChercheursByEnseignant(Integer idEnseignant);
    List<ResponseChercheurDto> getChercheursByProjet(Integer idEnseignant);
}
