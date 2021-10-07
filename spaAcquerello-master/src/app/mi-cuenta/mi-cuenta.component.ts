import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-mi-cuenta',
  templateUrl: './mi-cuenta.component.html',
  styleUrls: ['./mi-cuenta.component.css']
})

export class MiCuentaComponent implements OnInit {

  
  public usuario: Usuario = new Usuario("","","","","","");
  public aux: Usuario = new Usuario("","","","","","");
  public listaUsuarios: Usuario[] = [];
  public listaU2: Usuario[] = [];
  public correoA:string ="";
  public numItems: number = 0;


  constructor(private router:Router) { 


    var aux = localStorage.getItem('actual');
    //Se debe validar que no sea nulo el string.
    if(aux== null){
      this.correoA = "";
    }
    else{
      this.correoA = aux;
    }

    //Se debe validar que no sea nula la lista.
    var storageList = localStorage.getItem('localListaUsuarios');
    if(storageList== null){
      this.listaUsuarios = [];
    }
    else{
      this.listaUsuarios = JSON.parse(storageList);
    }
    this.buscarPersona(this.correoA);
  }

  ngOnInit(): void {
  }

  buscarPersona(correoA:string){
    for(let aux of this.listaUsuarios)
    {
      if(correoA == aux._email){
        this.usuario = aux;
      }
    }
  
  }

  darNumItem(){
    return this.numItems;
  }

  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

  actualizar(){
   
    for(let aux of this.listaUsuarios)
    {
      if(this.usuario._email != aux._email){
        this.listaU2.push(aux);
      }else{
        this.listaU2.push(this.usuario);
      }
    }

    localStorage.setItem('localListaUsuarios',JSON.stringify(this.listaU2));
    this.listaU2=[];

    this.router.navigateByUrl("/miCuenta");

  }
}
