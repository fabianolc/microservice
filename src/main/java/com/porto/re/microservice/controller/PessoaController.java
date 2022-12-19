package com.porto.re.microservice.controller;

import com.porto.re.microservice.domain.dto.PessoaDto;
import com.porto.re.microservice.mapper.PessoaMapper;
import com.porto.re.microservice.service.PessoaService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import static com.porto.re.microservice.config.MicroservicePathConfig.PESSOA;
import static org.springframework.http.ResponseEntity.ok;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    private PessoaMapper mapper = Mappers.getMapper(PessoaMapper.class);

    @PostMapping(path = PESSOA)
    public ResponseEntity<PessoaDto> save(PessoaDto pessoaDto) {
        return ok(mapper.toPessoaDto(pessoaService.save(pessoaDto)));
    }

}
