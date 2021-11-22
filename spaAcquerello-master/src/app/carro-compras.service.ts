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


  createCarroCompras (carroCompras: CarroCompras): Observable<any> {
    alert("Holiiiiiiiiiiiiiiiii "+carroCompras._nombreProducto);
    return this.http.post(this.Url +"/crear", carroCompras);
  }

  getlistaCarroCompras(){
    return this.http.get<CarroCompras[]>(this.Url+"/listaCarrosCompras");
  }

  getlistaCCXUsuario(idCarro:number){
    return this.http.get<CarroCompras[]>(this.Url+"/listaCarroComprasXUsuario/"+idCarro);
  }

  updateCarroCompras  (carroCompras: CarroCompras){
    return this.http.put(this.Url +"/actualizarCarro/"+carroCompras._id_CC, CarroCompras);
  }

  /*
  deleteCarroCompras (id_CC: number){
    return this.http.delete(this.Url+"/eliminar/"+id_CC);
  }*/
  
}
