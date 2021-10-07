import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/router';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-navegacion',
  templateUrl: './navegacion.component.html',
  styleUrls: ['./navegacion.component.css']
})
export class NavegacionComponent implements OnInit {
  public mostrarInicioG: boolean = true; //General
  public mostrarInicioU: boolean = true; //Usuario
  public mostrarInicioA: boolean = true; //Administrador
  public admin: Usuario = new Usuario("","","","","","");

  constructor() {

    var aux = localStorage.getItem('administrador');
    //Se debe validar que no sea nulo el string.
    if(aux== null){
      this.admin = new Usuario("","","","","","");
    }
    else{
      this.admin = JSON.parse(aux);
    }

    var aux1 = localStorage.getItem('actual');
    //Se debe validar que no sea nulo el string.
    if(aux1==""){
      this.mostrarInicioG = true; //General
      this.mostrarInicioU = false; //Usuario
      this.mostrarInicioA = false; //Administrador
    }
    else if(aux1 == this.admin._email ){
      this.mostrarInicioG = false; //General
      this.mostrarInicioU = false; //Usuario
      this.mostrarInicioA = true; //Administrador
    }
    else if(aux1 !="" && aux1 != this.admin._email){
      this.mostrarInicioG = false; //General
      this.mostrarInicioU = true; //Usuario
      this.mostrarInicioA = false; //Administrado
    }

  }

  ngOnInit(): void {
  }

  actualizar(){
    var aux1 = localStorage.getItem('actual');
    //Se debe validar que no sea nulo el string.
    if(aux1==""){
      this.mostrarInicioG = true; //General
      this.mostrarInicioU = false; //Usuario
      this.mostrarInicioA = false; //Administrador
    }
    else if(aux1 == this.admin._email ){
      this.mostrarInicioG = false; //General
      this.mostrarInicioU = false; //Usuario
      this.mostrarInicioA = true; //Administrador
    }
    else if(aux1 !="" && aux1 != this.admin._email){
      this.mostrarInicioG = false; //General
      this.mostrarInicioU = true; //Usuario
      this.mostrarInicioA = false; //Administrado
    }

  }

  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    this.mostrarInicioG = true; //General
    this.mostrarInicioU = false; //Usuario
    this.mostrarInicioA = false; //Administrador
  }

  

}
