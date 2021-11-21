import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CarroCompras } from './model/carroCompras';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarroComprasService {


  Url = 'http://localhost:8080/carroCompras';


  constructor(private http: HttpClient) {
    
   }


  createCarrroCompras (carrroCompras : any): Observable<any> {
    return this.http.post(this.Url +"/crear", carrroCompras);
  }

  getlistaCarrroCompras (){
    return this.http.get<CarroCompras[]>(this.Url+"/listaCarrrosCompras");
  }

  updateCarrroCompras  (carrroCompras: CarroCompras){ //{idPla}
    return this.http.put(this.Url +"/actualizarFactura/"+carrroCompras._id_CC, CarroCompras);
  }

  /*
  deleteCarrroCompras  (idFactura: number){
    return this.http.delete(this.Url+"/eliminar/"+id_CC);
  }
  */
}
