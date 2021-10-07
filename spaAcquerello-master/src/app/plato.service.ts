import { Injectable } from '@angular/core';
import { Plato } from './model/plato';

@Injectable({
  providedIn: 'root'
})
export class PlatoService {

  platoObtener:Plato =  new Plato('','','',0);
  public listaPlato: Plato[] = [];

  constructor() { 
  }

  getlistaPlato(){
    return this.listaPlato;
  }

}
