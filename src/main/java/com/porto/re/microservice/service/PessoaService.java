package com.porto.re.microservice.service;

import com.porto.re.microservice.domain.dto.PessoaDto;
import com.porto.re.microservice.domain.entity.Pessoa;

public interface PessoaService {
    Pessoa save(PessoaDto dto);
}
