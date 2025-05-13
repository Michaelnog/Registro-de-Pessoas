package com.michaelnog.GlobalTech.services.utils;

import com.michaelnog.GlobalTech.models.Pessoa;
import com.michaelnog.GlobalTech.models.dto.PessoaDto;
import org.springframework.stereotype.Service;

@Service
public class PessoaUtilService {

    public void updatePessoaBuilder (PessoaDto dto, Pessoa pessoaExistente) {

        pessoaExistente.setName(dto.getName());
        pessoaExistente.setDataNascimento(dto.getDataNascimento());
        pessoaExistente.setCpf(dto.getCpf());
        pessoaExistente.setSexo(dto.getSexo());
        pessoaExistente.setAltura(dto.getAltura());
        pessoaExistente.setPeso(dto.getPeso());
    }

}
