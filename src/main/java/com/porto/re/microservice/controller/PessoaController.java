package com.porto.re.microservice.controller;

import com.porto.re.microservice.domain.dto.PessoaDto;
import com.porto.re.microservice.mapper.PessoaMapper;
import com.porto.re.microservice.service.PessoaService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.porto.re.microservice.config.MicroservicePathConfig.PESSOA;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    private PessoaMapper mapper = Mappers.getMapper(PessoaMapper.class);

    @PostMapping(path = PESSOA, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaDto> save(@RequestBody PessoaDto pessoaDto) {
        return ok(mapper.toPessoaDto(pessoaService.save(pessoaDto)));
    }

    @GetMapping(path = PESSOA + "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaDto> get(@PathVariable("id") Long id) {
        return ok(mapper.toPessoaDto(pessoaService.find(id)));
    }

}
