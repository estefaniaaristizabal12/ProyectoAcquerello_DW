import { Injectable } from '@angular/core';
import { Plato } from './model/plato';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlatoService {

  idP: string = "1";

  platoObtener:Plato =  new Plato(0,'','','',0);
  public listaPlato: Plato[] = [];
  Url = 'http://localhost:8080/plato';


  constructor(private http: HttpClient) { 
  }


  createPlato (plato: any): Observable<any> {
    return this.http.post(this.Url +"/crear", plato);
  }

  getlistaPlato(){
    return this.http.get<Plato[]>(this.Url+"/listaPlatosEst");
  }

  updatePlato (plato: Plato){
    return this.http.put(this.Url +"/actualizarPlato/"+plato._idPlato, plato);
  }

  // updatePlato (plato: Plato){
  //   return this.http.put(this.Url +"/actualizarPlato/"+plato._idPlato, plato);
  // }

  deletePlato (idplato: any){
    return this.http.delete(this.Url+"/eliminar/"+idplato);
    //return this.http.delete(`${this.Url}/eliminar/${this.idP}`,this.idP);
      
      //this.Url +"/eliminar/"+idplato, idplato);
  }


  /* FUNCIONES GENERALES */

  private extractData(res: Response) {
    const body = res;
    return body || {};
}

private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
        const err = error || '';
        errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
        errMsg = error.message ? error.message : error.toString();
    }

    return throwError(errMsg);
}

}
