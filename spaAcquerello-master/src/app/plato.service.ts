import { Injectable } from '@angular/core';
import { Plato } from './model/plato';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlatoService {

  platoObtener:Plato =  new Plato(0,'','','',0);
  public listaPlato: Plato[] = [];
  Url = 'http://localhost:8080/plato';


  constructor(private http: HttpClient) { 
  }

  createPlato (plato: any): Observable<any> {
    return this.http.post(this.Url + "/crear", plato);
  }

  getlistaPlato(){
    return this.http.get<Plato[]>(this.Url+"/listaPlatosEst");
  }

  updatePlato (plato: Plato){
    return this.http.post(this.Url +"/actualizarPlato", plato);
  }

  deletePlato (plato: Plato){
    return this.http.post(this.Url + "/eliminar", plato);
  }
  
}
