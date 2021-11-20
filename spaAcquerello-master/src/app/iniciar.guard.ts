import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { CarroCompras } from './model/carroCompras';
import { Factura } from './model/factura';
import { Usuario } from './model/usuario';

@Injectable({
  providedIn: 'root'
})
export class IniciarGuard implements CanActivate {

  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];
  public admin: Usuario = new Usuario(0,"","","","","",this.auxx,this.auxxf,"");
  public correoA: string = "";
  canActivate(){

    //Aca se valida que el que este dentro sea un usuario para poder acceder a las pantallas
    var auxu= localStorage.getItem('actual');
    var auxa= localStorage.getItem('administrador');

    if(auxa== null){
      this.admin = new Usuario(0,"","","","","",this.auxx,this.auxxf,"");
    }
    else{
      this.admin = JSON.parse(auxa);
    }

    if(auxu==null ||auxu==""){
      return false;
    }
    else{
      this.correoA = auxu;
      if(this.admin._email == this.correoA){
        return false;
      }else{
        console.log("SI entree");
        return true;
      }

    }
  }
  
}
