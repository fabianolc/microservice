package com.porto.re.microservice.mapper;

import com.porto.re.microservice.domain.dto.PessoaDto;
import com.porto.re.microservice.domain.entity.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    PessoaDto toPessoaDto(Pessoa pessoa);

    Pessoa toPessoa(PessoaDto pessoaDto);
}
