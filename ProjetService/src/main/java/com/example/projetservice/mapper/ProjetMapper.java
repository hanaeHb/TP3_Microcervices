package com.example.projetservice.mapper;

import com.example.projetservice.dto.RequestProjetDto;
import com.example.projetservice.dto.ResponseProjetDto;
import com.example.projetservice.entity.projet;
import io.micrometer.observation.transport.ResponseContext;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

@Component
public class ProjetMapper {
    public projet DTO_TO_ENTITY(RequestProjetDto requestProjetDto) {
        projet projet = new projet();
        BeanUtils.copyProperties(requestProjetDto, projet);
        return  projet;
    }

    public ResponseProjetDto ENTITY_TO_DTO(projet projet) {
        ResponseProjetDto responseProjetDto = new ResponseProjetDto();
        BeanUtils.copyProperties(projet, responseProjetDto);
        return responseProjetDto;

    }
}
