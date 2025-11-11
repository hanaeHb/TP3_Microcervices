package com.example.chercheurservice.mapper;

import com.example.chercheurservice.dto.RequestChercheurDto;
import com.example.chercheurservice.dto.ResponseChercheurDto;
import com.example.chercheurservice.entity.chercheur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ChercheurMapper {
    public chercheur DTO_TO_ENTITY(RequestChercheurDto requestChercheurDto) {
        chercheur chercheur = new chercheur();
        BeanUtils.copyProperties(requestChercheurDto, chercheur);
        return  chercheur;
    }

    public ResponseChercheurDto ENTITY_TO_DTO(chercheur chercheur) {
        ResponseChercheurDto responseChercheurDto = new ResponseChercheurDto();
        BeanUtils.copyProperties(chercheur, responseChercheurDto);
        return responseChercheurDto;

    }
}
