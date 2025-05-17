import { Component } from '@angular/core';
import { Pessoa } from '../../services/types/types';
import { PessoaService } from '../../services/pessoa.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-pessoa-form',
  imports: [FormsModule],
  templateUrl: './pessoa-form.component.html',
  styleUrl: './pessoa-form.component.css'
})
export class PessoaFormComponent {
  [x: string]: any;

  titulo: string = 'Cadastro de Pessoas';
  pessoaId?: number;

  pessoa: Pessoa = {} as Pessoa;

  constructor(private service: PessoaService,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.pessoaId = Number(this.route.snapshot.params['id']);

    if (this.pessoaId) {
      service.buscarPorId(this.pessoaId).subscribe(pessoa => {

        if (pessoa) {
          this.pessoa.id = pessoa.id;
          this.pessoa.name = pessoa.name;
          this.pessoa.dataNascimento = pessoa.dataNascimento;
          this.pessoa.cpf = pessoa.cpf
          this.pessoa.sexo = pessoa.sexo;
          this.pessoa.altura = pessoa.altura;
          this.pessoa.peso = pessoa.peso;
          this.pessoa.pesoIdeal = pessoa.pesoIdeal;
        }
      })
    }

  }
  submeter() {
    this.pessoa.dataNascimento = this.convertToDDMMYYYY(this.pessoa.dataNascimento);
    
    if (this.pessoaId) {
      this.service.editar(this.pessoa).subscribe(() => {
        this.router.navigate(['/pessoas']);
      })
    } else {
      this.service.incluir(this.pessoa).subscribe(() => {
        this.router.navigate(['/pessoas']);
      })
    }
  }
 
  convertToDDMMYYYY(dateStr: String): string {
    const [year, month, day] = dateStr.split('-');
    return `${day}-${month}-${year}`;
  }

}
