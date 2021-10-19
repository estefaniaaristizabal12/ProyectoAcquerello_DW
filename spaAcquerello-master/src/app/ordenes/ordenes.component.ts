import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { CarroCompras } from '../model/carroCompras';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-ordenes',
  templateUrl: './ordenes.component.html',
  styleUrls: ['./ordenes.component.css']
})
export class OrdenesComponent implements OnInit {

  listaOrdenes: CarroCompras[] = [];
  dato: CarroCompras = new CarroCompras(0,"",0,0,"");
  public usuario: Usuario = new Usuario(0,"","","","","");
  public aux: Usuario = new Usuario(0,"","","","","");
  public listaUsuarios: Usuario[] = [];
  public correoA:string ="";


  constructor(public _usuarioService: UsuarioService, public router: Router) { 
    var aux1 = localStorage.getItem('actual');
    //Se debe validar que no sea nulo el string.
    if(aux1== null){
      this.correoA = "";
    }
    else{
      this.correoA = aux1;
    }

    console.log("holaaa" + this.correoA);
    //Se debe validar que no sea nula la lista.
    var storageList = localStorage.getItem('localListaUsuarios');
    if(storageList== null){
      this.listaUsuarios = [];
    }
    else{
      this.listaUsuarios = JSON.parse(storageList);
    }

    this.buscarPersona(this.correoA);

    //Aca toca cambiar a this.usuario.ordenes

    console.log(this.usuario._nombre);
    this.listaOrdenes = this.usuario.facturas;
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

  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

  



}
