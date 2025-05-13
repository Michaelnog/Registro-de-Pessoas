package com.michaelnog.GlobalTech.controllers;

import com.michaelnog.GlobalTech.models.dto.PessoaDto;
import com.michaelnog.GlobalTech.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/pessoa")
    public ResponseEntity<PessoaDto> criarPessoa(@RequestBody PessoaDto dto) {
        PessoaDto pessoaDto= pessoaService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> buscarPorId(@PathVariable Long id) {
        PessoaDto dto = pessoaService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PessoaDto>> buscarPorNome(@RequestParam String name) {
        List<PessoaDto> pessoasDto = pessoaService.buscarPorNome(name);
        return ResponseEntity.ok(pessoasDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PessoaDto>> listarTodas() {
        List<PessoaDto> pessoas = pessoaService.listarTodas();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PessoaDto> buscarPorCpf(@PathVariable String cpf) {
        PessoaDto pessoaDTO = pessoaService.buscarPorCpf(cpf);
        return ResponseEntity.ok(pessoaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaDto dto) {
        PessoaDto pessoaAtualizada = pessoaService.atualizar(id, dto);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/peso-ideal")
    public ResponseEntity<PessoaDto> calcularPesoIdeal(@PathVariable Long id) {
        PessoaDto dto = pessoaService.calcularPesoIdeal(id);
        return ResponseEntity.ok(dto);
    }
}