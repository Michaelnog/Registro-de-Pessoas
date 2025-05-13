package com.michaelnog.GlobalTech.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.michaelnog.GlobalTech.models.Pessoa;
import com.michaelnog.GlobalTech.models.enums.Sexo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto  {

    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private double altura;
    private double peso;

    private Double pesoIdeal;

    public PessoaDto(Pessoa pessoa){
        this.id = pessoa.getId();
        this.name = pessoa.getName();
        this.dataNascimento = pessoa.getDataNascimento();
        this.cpf = pessoa.getCpf();
        this.sexo = pessoa.getSexo();
        this.altura = pessoa.getAltura();
        this.peso = pessoa.getPeso();
        this.pesoIdeal = pessoa.getPesoIdeal();
    }

}
