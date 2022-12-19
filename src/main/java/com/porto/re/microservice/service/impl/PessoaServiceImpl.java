package com.porto.re.microservice.service.impl;

import com.porto.re.microservice.domain.dto.PessoaDto;
import com.porto.re.microservice.domain.entity.Pessoa;
import com.porto.re.microservice.mapper.PessoaMapper;
import com.porto.re.microservice.repository.PessoaRepository;
import com.porto.re.microservice.service.PessoaService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    private PessoaMapper mapper = Mappers.getMapper(PessoaMapper.class);

    @Override
    public Pessoa save(PessoaDto dto) {
        return repository.save(mapper.toPessoa(dto));
    }

}
