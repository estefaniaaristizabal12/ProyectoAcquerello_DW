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

  // - - - - - - - -  C   R   U  D  - - - - - - - - 

  createFactura (factura: any, correo: string){
    return this.http.post(this.Url +"/crear/"+correo, factura);
  }

  getlistaFactura(){
    return this.http.get<Factura[]>(this.Url+"/listaFacturas");
  }

  getlistaFacturaXUsuario(idFactura:number){
    return this.http.get<Factura[]>(this.Url+"/listaFacturasXUsuario/"+idFactura);
  }

  getlistaFacturasXIdUsuario (idUsuario: number){
    return this.http.get<Factura[]>(this.Url+"/listaFacturasXidUsuario/"+idUsuario);
  }

  updateFactura (factura: Factura){
    return this.http.put(this.Url +"/actualizarFactura/"+factura.idFactura, factura);
  }

  deleteFactura (idFactura: number){
    return this.http.delete(this.Url+"/eliminar/"+idFactura);
  }

}
