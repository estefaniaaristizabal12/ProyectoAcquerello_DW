import { Injectable } from '@angular/core';
import { Plato } from './model/plato';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlatoService {

  idP: string = "1";

  public platoObtener:Plato =  new Plato(0,'','','',0);
  plato:Plato =  new Plato(0,'','','',0);
  public listaPlato: Plato[] = [];
  Url = 'http://localhost:8080/plato';


  constructor(private http: HttpClient) { 
    this.getlistaPlato()
    .subscribe(data =>{
      this.listaPlato = data;
    }) ;  
  }


  createPlato (plato: any): Observable<any> {
    return this.http.post(this.Url +"/crear", plato);
  }

  getlistaPlato(){
    return this.http.get<Plato[]>(this.Url+"/listaPlatos");
  }

  getPlatoXId(idPlato: number){
    return this.http.get<Plato>(this.Url+"/darPlatoXId/"+idPlato);
  }

  getPlatoXNombre(nombrePlato: string){
    return this.http.get<Plato>(this.Url+"/darPlatoXNombre/"+nombrePlato);
  }

  updatePlato (plato: Plato){
    return this.http.put(this.Url +"/actualizarPlato/"+plato._idPlato, plato);
  }


  deletePlato (idplato: number){
    return this.http.delete(this.Url+"/eliminar/"+idplato);
  }

  darPlatoXNombre (nombrePlato: string){
    for(let plato of this.listaPlato){
      if(nombrePlato == plato._nombre){
        return plato._idPlato;
      }
    }
    return 0;
  }

}
