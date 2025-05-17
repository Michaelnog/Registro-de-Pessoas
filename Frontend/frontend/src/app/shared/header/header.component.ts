import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [RouterModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  exibirLogo: boolean = false;


  itensMenu = [
    {label: 'Pessoas', link: '/pessoas'},
    {label: 'Cadastro', link: 'pessoas/incluir'},
    {label: 'Login', link: 'pessoas/login'},
    
  ];

}
