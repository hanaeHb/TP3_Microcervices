package com.example.enseignant_service.service;

import com.example.enseignant_service.dto.RequestEnseignantDto;
import com.example.enseignant_service.dto.ResponseEnseignantDto;
import com.example.enseignant_service.entity.enseignant;
import com.example.enseignant_service.mapper.EnseignantMapper;
import com.example.enseignant_service.repository.EnseignantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    public EnseignantMapper enseignantMapper;
    public EnseignantRepository enseignantRepository;

    public EnseignantServiceImpl(EnseignantMapper enseignantMapper,  EnseignantRepository enseignantRepository) {
        this.enseignantMapper = enseignantMapper;
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public ResponseEnseignantDto Add_Enseignant(RequestEnseignantDto requestEnseignantDto) {
        enseignant enseignant = enseignantMapper.DTO_TO_ENTITY(requestEnseignantDto);
        enseignant savedEnseignant = enseignantRepository.save(enseignant);
        return enseignantMapper.ENTITY_TO_DTO(savedEnseignant);
    }

    @Override
    public List<ResponseEnseignantDto> GETALLEnseignant() {
        List<enseignant> enseignants = enseignantRepository.findAll();
        List<ResponseEnseignantDto> EnseignantDTOs = new ArrayList<>();
        for (enseignant enseignant : enseignants) {
            EnseignantDTOs.add(enseignantMapper.ENTITY_TO_DTO(enseignant));
        }
        return EnseignantDTOs;
    }

    @Override
    public ResponseEnseignantDto GETEnseignantById(Integer id) {
        enseignant enseignant = enseignantRepository.findById(id).orElseThrow();
        return enseignantMapper.ENTITY_TO_DTO(enseignant);
    }

    @Override
    public ResponseEnseignantDto UPDATEEnseignant(Integer id, RequestEnseignantDto requestEnseignantDto) {
        enseignant newenseignant = enseignantMapper.DTO_TO_ENTITY(requestEnseignantDto);
        enseignant enseignant = enseignantRepository.findById(id).orElseThrow();

        if(newenseignant.getNom()!=null) enseignant.setNom(newenseignant.getNom());
        if(newenseignant.getPrenom()!=null) enseignant.setPrenom(newenseignant.getPrenom());
        if(newenseignant.getCne()!=null) enseignant.setCne(newenseignant.getCne());

        enseignant savedEnseignant = enseignantRepository.save(enseignant);
        return enseignantMapper.ENTITY_TO_DTO(savedEnseignant);
    }

    @Override
    public void DELETEEnseignantBYID(Integer id) {
        enseignantRepository.deleteById(id);
    }
}
