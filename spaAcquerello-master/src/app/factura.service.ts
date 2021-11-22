import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Factura } from './model/factura';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  Url = 'http://localhost:8080/factura';


  constructor(private http: HttpClient) { 
  }


  createFactura (factura: any): Observable<any> {
    return this.http.post(this.Url +"/crear", factura);
  }

  getlistaFactura(){
    return this.http.get<Factura[]>(this.Url+"/listaFacturas");
  }

  getlistaFacturaXUsuario(idFactura:number){
    return this.http.get<Factura[]>(this.Url+"/listaFacturasXUsuario"+idFactura);
  }

  updateFactura (factura: Factura){ //{idPla}
    return this.http.put(this.Url +"/actualizarFactura/"+factura.idFactura, factura);
  }

  deleteFactura (idFactura: number){
    return this.http.delete(this.Url+"/eliminar/"+idFactura);
  }

}
