import { Injectable } from '@angular/core';
import { Usuario } from './model/usuario';
import { HttpClient } from '@angular/common/http';
import { Factura } from './model/factura';
import { CarroCompras } from './model/carroCompras';
import { Observable } from 'rxjs';

/*
import { Injectable } from '@angular/core';
import { Plato } from './model/plato';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
*/

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];
  public listaUsuarios: Usuario[] = [];
  public res: Usuario = new Usuario(0,"","","","","","");
  public usuarioActual: Usuario = new Usuario(0,"","","","","","");
  usuarioObtener:Usuario =  new Usuario(0,"","","","","","");
  Url = 'http://localhost:8080/usuario';


  constructor(private http: HttpClient) { 
    this.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;  

  }

  getlistaUsuario(){
    return this.http.get<Usuario[]>(this.Url+"/listaUsuarios");
  }

  agregar(usuario :Usuario){
    //excepto esto
    this.listaUsuarios.push(usuario);
    //Cada que se aniada un nuevo usuario, sobreescribe la lista de localListaUsuarios
    localStorage.setItem('localListaUsuarios', JSON.stringify(this.listaUsuarios));
  }



  ///______________________ nuevo __________________________

  createUsuario (usuario: any): Observable<any> {
    return this.http.post(this.Url +"/crear", usuario);
  }

  updateUsuario(usuario: Usuario){ 
    return this.http.put(this.Url +"/actualizarUsuario/"+usuario._idUsuario, usuario);
  }


  getUsuarioXEmail(correo: string){
    return this.http.get<Usuario>(this.Url+"/darUsuarioXEmail/"+correo);
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
    this.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;

    for(let usuario of this.listaUsuarios){
      if(emailP == usuario._email){
        if(contrasenaP == usuario._contrasenia){
          return true;
        }
      }
    }
    return false;
  }

  darRol(emailP:String){
    for(let usuario of this.listaUsuarios)
    {
      if(emailP == usuario._email){
        return usuario._rol;
      }
    }

    return "";
  }

  fijarUsuarioActual(emailP:string){
    localStorage.setItem('actual',emailP);
    return this.usuarioActual;
  }

  darUsuario(emailP:string){

    this.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;


    for(let usuario of this.listaUsuarios)
    {
      if(emailP == usuario._email){
        this.usuarioActual = usuario;
        this.fijarUsuarioActual(emailP);
        return usuario;
      }
    }
    return new Usuario(0,"","","","","","");
  }

  async async_print_personas() {
    await new Promise((f) => setTimeout(f, 1000));
    console.log(this.listaUsuarios);
  }

}
