import { Injectable } from '@angular/core';
import { CarroCompras } from './model/carroCompras';
import { Usuario } from './model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  
  public listaUsuarios: Usuario[] = [];
  public usuario: Usuario = new Usuario("","","","","","");
  public usuarioActual: Usuario = new Usuario("","","","","","");

  

  constructor() { 

    //Aca toca actualizar con lo del LocalStorage
    var storageList = localStorage.getItem('localListaUsuarios');
    if(storageList== null){
      this.listaUsuarios = [];
    }
    else{
      this.listaUsuarios = JSON.parse(storageList);
    }
  }
  agregar(usuario :Usuario){
    
    //excepto esto
    this.listaUsuarios.push(usuario);
    //Cada que se aniada un nuevo usuario, sobreescribe la lista de localListaUsuarios
    localStorage.setItem('localListaUsuarios', JSON.stringify(this.listaUsuarios));
  }

  modificarUsuario(nListaUsuarios:Usuario[]){
    localStorage.setItem('localListaUsuarios', JSON.stringify(nListaUsuarios));
  }

  crearUsuario(){
    localStorage.setItem('user','wilmer');
  }

  buscarPersona(emailP:string){

    for(let usuario of this.listaUsuarios)
    {
      if(emailP == usuario._email){
        return true;
      }
    }
    return false;
  }

  verificarContrasenia(emailP:string, contrasenaP:string){
    for(let usuario of this.listaUsuarios)
    {
      if(emailP == usuario._email){
        if(contrasenaP == usuario._contrasenia){
          return true;
        }
      }
    }
    return false;
  }

  fijarUsuarioActual(emailP:string){
    localStorage.setItem('actual',emailP);
    return this.usuarioActual;
  }

  darUsuario(emailP:string){
    for(let usuario of this.listaUsuarios)
    {
      if(emailP == usuario._email){
        this.usuarioActual = usuario;
        this.fijarUsuarioActual(emailP);
        return usuario;
      }
    }
    return new Usuario("","","","","","");
  }

  



}
