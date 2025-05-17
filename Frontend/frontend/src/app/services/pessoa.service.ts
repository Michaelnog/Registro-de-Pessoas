import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pessoa } from './types/types';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  private readonly BASE_URL = 'http://localhost:8080/pessoas'

  constructor(private http:HttpClient) { }
  
  listar(): Observable<Pessoa[]>{
    return this.http.get<Pessoa[]>(`${this.BASE_URL}/list`);
  }
  incluir(pessoa: Pessoa): Observable<Pessoa>{
    return this.http.post<Pessoa>(`${this.BASE_URL}/pessoa`, pessoa);
  }

  excluir(id: Number): Observable<Pessoa>{
    return this.http.delete<Pessoa>(`${this.BASE_URL}/${id}`);
  }
  
  pesquisarPorNome(nome: string) {
    return this.http.get<Pessoa[]>(`/api/pessoas?nome=${nome}`);
  }

  buscarPorId(id: number): Observable<Pessoa | undefined>{
    return this.http.get<Pessoa>(`${this.BASE_URL}/${id}`);
  }
  
  editar(pessoa: Pessoa): Observable<Pessoa> {
    const url = `${this.BASE_URL}/${pessoa.id}`;
    return this.http.put<Pessoa>(url, pessoa);
  }

  calcularPesoIdeal(id: number): Observable<Pessoa> {
    return this.http.get<Pessoa>(`${this.BASE_URL}/pessoa/${id}/peso-ideal`);
  }

}
