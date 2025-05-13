package com.michaelnog.GlobalTech.models.mapper;

import com.michaelnog.GlobalTech.models.Pessoa;
import com.michaelnog.GlobalTech.models.dto.PessoaDto;
import com.michaelnog.GlobalTech.models.enums.Sexo;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaDto toDTO(Pessoa pessoa);

    Pessoa toEntity(PessoaDto dto);

    default PessoaDto toDTOWithPesoIdeal(Pessoa pessoa) {
        PessoaDto dto = toDTO(pessoa);

        if (pessoa.getSexo() == Sexo.MASCULINO) {
            dto.setPesoIdeal((72.7 * pessoa.getAltura()) - 58);
        } else if (pessoa.getSexo() == Sexo.FEMININO) {
            dto.setPesoIdeal((62.1 * pessoa.getAltura()) - 44.7);
        } else {
            dto.setPesoIdeal(null);
        }

        return dto;
    }
}
