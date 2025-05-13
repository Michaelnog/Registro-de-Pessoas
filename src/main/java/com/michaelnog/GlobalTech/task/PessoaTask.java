package com.michaelnog.GlobalTech.task;

import com.michaelnog.GlobalTech.models.Pessoa;
import com.michaelnog.GlobalTech.models.enums.Sexo;
import com.michaelnog.GlobalTech.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PessoaTask {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {

        double pesoIdeal = 0.0;
        if (pessoa.getSexo() == Sexo.MASCULINO) {
            pesoIdeal = (72.7 * pessoa.getAltura()) - 58;
        } else if (pessoa.getSexo() == Sexo.FEMININO) {
            pesoIdeal = (62.1 * pessoa.getAltura()) - 44.7;
        }

        pessoa.setPesoIdeal(pesoIdeal);
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public List<Pessoa> buscarPorNome(String name) {
        return pessoaRepository.findByName(name);
    }

    public Optional<Pessoa> buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public void deletar(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }
}