package com.example.chercheurservice.service;

import com.example.chercheurservice.dto.RequestChercheurDto;
import com.example.chercheurservice.dto.ResponseChercheurDto;
import com.example.chercheurservice.entity.chercheur;
import com.example.chercheurservice.feign.EnseignantRestClient;
import com.example.chercheurservice.feign.ProjetRestClient;
import com.example.chercheurservice.mapper.ChercheurMapper;
import com.example.chercheurservice.model.enseignant;
import com.example.chercheurservice.repository.ChercheurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChercheurServiceImpl implements ChercheurService {

    private final EnseignantRestClient enseignantRestClient;
    private final ProjetRestClient projetRestClient;
    public ChercheurMapper chercheurMapper;
    public ChercheurRepository  chercheurRepository;

    public ChercheurServiceImpl(ChercheurMapper chercheurMapper, ChercheurRepository chercheurRepository, EnseignantRestClient enseignantRestClient, ProjetRestClient projetRestClient) {
        this.chercheurMapper = chercheurMapper;
        this.chercheurRepository = chercheurRepository;
        this.enseignantRestClient = enseignantRestClient;
        this.projetRestClient = projetRestClient;
    }

    public enseignant getEnseignantById(Integer id) {
        return enseignantRestClient.getEnseignantById(id);
    }

    @Override
    public ResponseChercheurDto Add_Chercheur(RequestChercheurDto dto) {
        enseignantRestClient.getEnseignantById(dto.getIdEnseignant());
        projetRestClient.getProjetById(dto.getIdProjet());
        chercheur chercheur = chercheurMapper.DTO_TO_ENTITY(dto);
        chercheur savedChercheur = chercheurRepository.save(chercheur);
        return chercheurMapper.ENTITY_TO_DTO(savedChercheur);
    }


    @Override
    public List<ResponseChercheurDto> GETALLChercheur() {
        return chercheurRepository.findAll().stream().map(chercheurMapper::ENTITY_TO_DTO).collect(Collectors.toList());
    }

    @Override
    public ResponseChercheurDto GETChercheurById(Integer id) {
        return chercheurMapper.ENTITY_TO_DTO(chercheurRepository.findById(id).orElseThrow());
    }

    @Override
    public ResponseChercheurDto UPDATEChercheur(Integer id, RequestChercheurDto dto) {
        chercheur newChercheurData = chercheurMapper.DTO_TO_ENTITY(dto);

        chercheur existingChercheur = chercheurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chercheur not found with id: " + id));

        if(newChercheurData.getNom() != null) existingChercheur.setNom(newChercheurData.getNom());
        if(newChercheurData.getPrenom() != null) existingChercheur.setPrenom(newChercheurData.getPrenom());
        if(newChercheurData.getEmail() != null) existingChercheur.setEmail(newChercheurData.getEmail());
        if(newChercheurData.getNumeroInscription() != null) existingChercheur.setNumeroInscription(newChercheurData.getNumeroInscription());
        if(dto.getIdEnseignant() != null) existingChercheur.setIdEnseignant(dto.getIdEnseignant());

        chercheur savedChercheur = chercheurRepository.save(existingChercheur);

        return chercheurMapper.ENTITY_TO_DTO(savedChercheur);
    }


    @Override
    public void DELETEChercheurBYID(Integer id) {
        chercheurRepository.deleteById(id);
    }

    @Override
    public List<ResponseChercheurDto> getChercheursByEnseignant(Integer enseignantId) {
        return chercheurRepository.findByIdEnseignant(enseignantId).stream().map(chercheurMapper::ENTITY_TO_DTO).collect(Collectors.toList());
    }

    @Override
    public List<ResponseChercheurDto> getChercheursByProjet(Integer idProjet) {
        return chercheurRepository.findByIdProjet(idProjet)
                .stream()
                .map(chercheurMapper::ENTITY_TO_DTO)
                .collect(Collectors.toList());
    }

}
