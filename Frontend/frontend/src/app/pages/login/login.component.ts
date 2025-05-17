import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  login: string = '';
  senha: string = '';

  constructor(private router: Router) { }

  onBotaoClicado(): void {
    if (this.login.trim() !== '' && this.senha.trim() !== '') {
      if (this.login === 'admin' && this.senha.trim() === '1234') {
        this.router.navigate(['/pessoas'])

      } else {
        alert('Dados invalidos')
      }
    } else {
      alert('Preencha todos os campos!')
    }
  }
}