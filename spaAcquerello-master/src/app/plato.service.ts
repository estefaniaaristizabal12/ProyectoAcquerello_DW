import { Injectable } from '@angular/core';
import { Plato } from './model/plato';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PlatoService {

  platoObtener:Plato =  new Plato(0,'','','',0);
  public listaPlato: Plato[] = [];


  constructor(private http: HttpClient) { 
  }

  getlistaPlato(){
    let Url = 'http://localhost:8080/plato';
    //this.http.get<Plato[]>(this.Url+"/listarPlatos");
    return this.http.get<Plato[]>(Url+"/listarPlatos");
  }

}
