package com.example.chercheurservice.service;

import com.example.chercheurservice.dto.RequestChercheurDto;
import com.example.chercheurservice.dto.ResponseChercheurDto;
import com.example.chercheurservice.entity.chercheur;
import com.example.chercheurservice.mapper.ChercheurMapper;
import com.example.chercheurservice.repository.ChercheurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChercheurServiceImpl implements ChercheurService {

    public ChercheurMapper chercheurMapper;
    public ChercheurRepository  chercheurRepository;

    public ChercheurServiceImpl(ChercheurMapper chercheurMapper, ChercheurRepository chercheurRepository) {
        this.chercheurMapper = chercheurMapper;
        this.chercheurRepository = chercheurRepository;
    }

    @Override
    public ResponseChercheurDto Add_Chercheur(RequestChercheurDto requestChercheurDto) {
        chercheur chercheur = chercheurMapper.DTO_TO_ENTITY(requestChercheurDto);
        chercheur savedChercheur = chercheurRepository.save(chercheur);
        return chercheurMapper.ENTITY_TO_DTO(savedChercheur);
    }

    @Override
    public List<ResponseChercheurDto> GETALLChercheur() {
        List<chercheur> chercheurs = chercheurRepository.findAll();
        List<ResponseChercheurDto> ChercheurDTOs = new ArrayList<>();
        for (chercheur chercheur : chercheurs) {
            ChercheurDTOs.add(chercheurMapper.ENTITY_TO_DTO(chercheur));
        }
        return ChercheurDTOs;
    }

    @Override
    public ResponseChercheurDto GETChercheurById(Integer id) {
        chercheur chercheur = chercheurRepository.findById(id).orElseThrow();
        return chercheurMapper.ENTITY_TO_DTO(chercheur);
    }

    @Override
    public ResponseChercheurDto UPDATEChercheur(Integer id, RequestChercheurDto requestChercheurDto) {
        chercheur newchercheur = chercheurMapper.DTO_TO_ENTITY(requestChercheurDto);
        chercheur chercheur = chercheurRepository.findById(id).orElseThrow();

        if(newchercheur.getNom()!=null) chercheur.setNom(newchercheur.getNom());
        if(newchercheur.getPrenom()!=null) chercheur.setPrenom(newchercheur.getPrenom());
        if(newchercheur.getNumeroInscription()!=null) chercheur.setNumeroInscription(newchercheur.getNumeroInscription());

        chercheur savedChercheur= chercheurRepository.save(chercheur);
        return chercheurMapper.ENTITY_TO_DTO(savedChercheur);
    }

    @Override
    public void DELETEChercheurBYID(Integer id) {
        chercheurRepository.deleteById(id);
    }
}
