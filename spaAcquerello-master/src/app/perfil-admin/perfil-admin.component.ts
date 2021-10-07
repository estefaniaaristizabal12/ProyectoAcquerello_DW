import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-perfil-admin',
  templateUrl: './perfil-admin.component.html',
  styleUrls: ['./perfil-admin.component.css']
})
export class PerfilAdminComponent implements OnInit {

  public usuario: Usuario = new Usuario("","","","","","");
  public aux: Usuario = new Usuario("","","","","","");
  public correoA:string ="";
  public numItems: number = 0;


  constructor() { 
    var aux = localStorage.getItem('administrador');
    //Se debe validar que no sea nulo el string.
    if(aux== null){
      this.usuario = new Usuario("","","","","","");
    }
    else{
      this.usuario = JSON.parse(aux);
    }
 
  }

  ngOnInit(): void {
  }

  actualizar(){
    localStorage.setItem('administrador',JSON.stringify(this.usuario));
    alert("Se actualizó correctamente la información!");
  }


  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

}
