package com.example.enseignant_service.mapper;

import com.example.enseignant_service.dto.RequestEnseignantDto;
import com.example.enseignant_service.dto.ResponseEnseignantDto;
import com.example.enseignant_service.entity.enseignant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EnseignantMapper {
    public enseignant DTO_TO_ENTITY(RequestEnseignantDto requestEnseignantDto) {
        enseignant enseignant = new enseignant();
        BeanUtils.copyProperties(requestEnseignantDto, enseignant);
        return  enseignant;
    }

    public ResponseEnseignantDto ENTITY_TO_DTO(enseignant enseignant) {
        ResponseEnseignantDto responseEnseignantDto = new ResponseEnseignantDto();
        BeanUtils.copyProperties(enseignant, responseEnseignantDto);
        return responseEnseignantDto;

    }
}
