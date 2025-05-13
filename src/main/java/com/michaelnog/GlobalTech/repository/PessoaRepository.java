package com.michaelnog.GlobalTech.repository;

import com.michaelnog.GlobalTech.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa ,Long> {

    List<Pessoa> findAll();

    List<Pessoa>findByName(String name);

    Optional<Pessoa> findByCpf(String cpf);
}
