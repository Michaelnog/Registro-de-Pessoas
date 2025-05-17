
import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../services/types/types';
import { PessoaService } from '../services/pessoa.service';
import { Router, RouterLink } from '@angular/router';
import { NgStyle } from '@angular/common';

@Component({
  selector: 'app-pessoa-listagem',
  imports: [RouterLink,NgStyle],
  templateUrl: './pessoa-listagem.component.html',
  styleUrl: './pessoa-listagem.component.css'
})
export class PessoaListagemComponent implements OnInit {
  [x: string]: any;

  listaPessoas: Pessoa[] = [];

  constructor(private service: PessoaService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.service.listar().subscribe((pessoas) => {
      this.listaPessoas = pessoas;
    })
  }

  excluir(id: number) {
    if (id) {
      this.service.excluir(id).subscribe(() => {
        window.location.reload()
      })
    }

  }
  modalAberto = false;
  pessoaSelecionada: any = null;

  abrirPopup(pessoa: any) {
    this.pessoaSelecionada = pessoa;
    this.modalAberto = true;
  }

  fecharPopup() {
    this.modalAberto = false;
    this.pessoaSelecionada = null; 
  }

}
