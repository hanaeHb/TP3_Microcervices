package com.example.projetservice.service;

import com.example.projetservice.dto.RequestProjetDto;
import com.example.projetservice.dto.ResponseProjetDto;
import com.example.projetservice.entity.projet;
import com.example.projetservice.mapper.ProjetMapper;
import com.example.projetservice.repository.ProjetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService {
    public ProjetServiceImpl(ProjetRepository projetRepository, ProjetMapper projetMapper) {
        this.projetRepository = projetRepository;
        this.projetMapper = projetMapper;
    }

    private ProjetRepository projetRepository;
    private ProjetMapper  projetMapper;

    @Override
    public ResponseProjetDto Add_Projet(RequestProjetDto requestProjetDto) {
        projet projet = projetMapper.DTO_TO_ENTITY(requestProjetDto);
        projet savedProjet = projetRepository.save(projet);
        return projetMapper.ENTITY_TO_DTO(savedProjet);
    }

    @Override
    public List<ResponseProjetDto> GETALLProjet() {
        List<projet> projets = projetRepository.findAll();
        List<ResponseProjetDto> projetDTOs = new ArrayList<>();
        for (projet projet : projets) {
            projetDTOs.add(projetMapper.ENTITY_TO_DTO(projet));
        }
        return projetDTOs;
    }

    @Override
    public ResponseProjetDto GETProjetById(Integer id) {
        projet projet = projetRepository.findById(id).orElseThrow();
        return projetMapper.ENTITY_TO_DTO(projet);
    }

    @Override
    public ResponseProjetDto UPDATEProjet(Integer id, RequestProjetDto requestProjetDto) {
        projet newprojet = projetMapper.DTO_TO_ENTITY(requestProjetDto);
        projet projet = projetRepository.findById(id).orElseThrow();

        if(newprojet.getTitre()!=null) projet.setTitre(newprojet.getTitre());
        if(newprojet.getDescription()!=null) projet.setDescription(newprojet.getDescription());

        projet savedProjet= projetRepository.save(projet);
        return projetMapper.ENTITY_TO_DTO(savedProjet);
    }

    @Override
    public void DELETEProjetBYID(Integer id) {
        projetRepository.deleteById(id);
    }
}
