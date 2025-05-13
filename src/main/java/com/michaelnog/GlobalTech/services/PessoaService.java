package com.michaelnog.GlobalTech.services;

import com.michaelnog.GlobalTech.models.Pessoa;
import com.michaelnog.GlobalTech.models.dto.PessoaDto;
import com.michaelnog.GlobalTech.models.mapper.PessoaMapper;
import com.michaelnog.GlobalTech.models.enums.Sexo;
import com.michaelnog.GlobalTech.repository.PessoaRepository;
import com.michaelnog.GlobalTech.services.utils.PessoaUtilService;
import com.michaelnog.GlobalTech.task.PessoaTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaTask pessoaTask;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private PessoaUtilService pessoaUtilService;


    public PessoaDto salvar(PessoaDto dto) {
        Pessoa pessoa = new Pessoa(dto);
        pessoa = pessoaTask.salvar(pessoa);
        return  new PessoaDto(pessoa);
    }

    public List<PessoaDto> listarTodas() {
        List<Pessoa> pessoas = pessoaTask.listarTodas();
        List<PessoaDto> pessoaDtos = pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
        return pessoaDtos;

    }

    public List<PessoaDto> buscarPorNomeContendo(String name) {
        return pessoaTask.buscarPorNome(name).stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDto buscarPorCpf(String cpf) {
        Pessoa pessoa = pessoaTask.buscarPorCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Pessoa com CPF não encontrada"));
        return pessoaMapper.toDTO(pessoa);
    }

    public PessoaDto atualizar(Long id, PessoaDto dto) {
        Pessoa pessoaExistente = pessoaTask.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o id: " + id));
         pessoaUtilService.updatePessoaBuilder(dto,pessoaExistente);
         pessoaTask.salvar(pessoaExistente);
        return pessoaMapper.toDTO(pessoaExistente);
    }

    public void deletar(Long id) {
        Pessoa pessoa = pessoaTask.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o id: " + id));
        pessoaTask.deletar(pessoa);
    }

    public List<PessoaDto> buscarPorNome(String name) {
        return pessoaTask.buscarPorNome(name).stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDto calcularPesoIdeal(Long id) {
        Pessoa pessoa = pessoaTask.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada : " + id));

        return pessoaMapper.toDTOWithPesoIdeal(pessoa);
    }

    public PessoaDto buscarPorId(Long id) {
        Pessoa pessoa = pessoaTask.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id: " + id));
        return pessoaMapper.toDTO(pessoa);
    }
}
