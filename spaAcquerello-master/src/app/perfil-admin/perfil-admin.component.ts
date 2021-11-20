import { Component, OnInit } from '@angular/core';
import { CarroCompras } from '../model/carroCompras';
import { Factura } from '../model/factura';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-perfil-admin',
  templateUrl: './perfil-admin.component.html',
  styleUrls: ['./perfil-admin.component.css']
})
export class PerfilAdminComponent implements OnInit {

  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];

  public usuario: Usuario = new Usuario(0,"","","","","",this.auxx,this.auxxf,"");
  public aux: Usuario = new Usuario(0,"","","","","",this.auxx,this.auxxf,"");
  public correoA:string ="";
  public numItems: number = 0;


  constructor() { 
    var aux = localStorage.getItem('administrador');
    //Se debe validar que no sea nulo el string.
    if(aux== null){
      this.usuario = new Usuario(0,"","","","","",this.auxx,this.auxxf,"");
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
