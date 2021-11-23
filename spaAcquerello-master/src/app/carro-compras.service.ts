import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CarroCompras } from './model/carroCompras';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CarroComprasService {


  Url = 'http://localhost:8080/carroCompras';

  public carro: CarroCompras[] = [];


  constructor(private http: HttpClient) {
    
   }


  createCarroCompras (carroCompras : any, correo: string){
    return this.http.post(this.Url +"/crear/"+correo, carroCompras);
  }

  getlistaCarroCompras (){
    return this.http.get<CarroCompras[]>(this.Url+"/listaCarrosCompras");
  }

  getlistaCarroComprasXIdUsuario (idUsuario: number){
    return this.http.get<CarroCompras[]>(this.Url+"/listaCarroComprasXidUsuario/"+idUsuario);
  }

  updateCarroCompras (carroCompras: CarroCompras){ 
    return this.http.put(this.Url +"/actualizarCarroCompras/"+carroCompras._id_CC, carroCompras);
  }

  deleteProductoCarro (idCC: number){
    return this.http.delete(this.Url+"/eliminar/"+idCC);
  }

  deleteCarroUsuario (idUsuario: number){
    return this.http.delete(this.Url+"/eliminarXUsuario/"+idUsuario);
  }

}
