package com.michaelnog.GlobalTech.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.michaelnog.GlobalTech.models.dto.PessoaDto;
import com.michaelnog.GlobalTech.models.enums.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

    @Entity
    @Table(name = "pessoa")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Pessoa  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataNascimento;
        private String cpf;

        @Enumerated(EnumType.STRING)
        private Sexo sexo;

        private double altura;
        private double peso;
        private Double pesoIdeal;

        public Pessoa(PessoaDto dto){
            this.name = dto.getName();
            this.dataNascimento = dto.getDataNascimento();
            this.cpf = dto.getCpf();
            this.sexo = dto.getSexo();
            this.altura = dto.getAltura();
            this.peso = dto.getPeso();
            this.pesoIdeal = getPesoIdeal();
        }

    }
