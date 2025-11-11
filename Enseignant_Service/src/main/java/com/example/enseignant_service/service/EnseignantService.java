package com.example.enseignant_service.service;

import com.example.enseignant_service.dto.RequestEnseignantDto;
import com.example.enseignant_service.dto.ResponseEnseignantDto;

import java.util.List;

public interface EnseignantService {
    public ResponseEnseignantDto Add_Enseignant(RequestEnseignantDto requestEnseignantDto);
    public List<ResponseEnseignantDto> GETALLEnseignant();
    public ResponseEnseignantDto GETEnseignantById(Integer id);
    public ResponseEnseignantDto UPDATEEnseignant(Integer id , RequestEnseignantDto requestEnseignantDto);
    public void DELETEEnseignantBYID(Integer id);
}
