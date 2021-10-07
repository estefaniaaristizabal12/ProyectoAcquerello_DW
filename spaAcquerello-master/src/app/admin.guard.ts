import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { Usuario } from './model/usuario';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  public admin: Usuario = new Usuario("","","","","","");
  public correoA: string = "";
  canActivate(){

    //Aca se valida que el que este dentro sea un usuario para poder acceder a las pantallas
    var auxu= localStorage.getItem('actual');
    var auxa= localStorage.getItem('administrador');

    if(auxa== null){
      this.admin = new Usuario("","","","","","");
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
        return true;
      }else{
        return false;
      }

    }
  }
  
}
