import { DatePipe } from '@angular/common';
import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarroCompras } from '../model/carroCompras';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-carro-compras',
  templateUrl: './carro-compras.component.html',
  styleUrls: ['./carro-compras.component.css']
})
export class CarroComprasComponent implements OnInit {
  
  listaCC: CarroCompras[] = [];
  listaCC2: CarroCompras[] = [];
  dato: CarroCompras = new CarroCompras("",0,0,"");
  aux2: CarroCompras = new CarroCompras("",0,0,"");
  public usuario: Usuario = new Usuario("","","","","","");
  public aux: Usuario = new Usuario("","","","","","");
  public listaUsuarios: Usuario[] = [];
  public listaU2: Usuario[] = [];
  public correoA:string ="";
  public numItems: number = 0;
  public total: number = 0;
  public subtotal: number = 0;
  public mostrar: boolean = false;
  public mostrarT: boolean = false;



  constructor(public router: Router) { 
    this.total = 0;
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

    //Aca toca cambiar a this.usuario.ordenes

    console.log(this.usuario._nombre);
    this.listaCC = this.usuario.listaCC;
    if(this.listaCC.length>0){
      this.mostrar =  true;
    }else{
      this.mostrarT = true;
    }
    this.numItems = this.listaCC.length;
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

  darSubtotal(){
    this.subtotal = 0;
    for(let dato of this.listaCC)
    {
      this.subtotal = this.subtotal + dato._cantidad * dato._precio;
    }
    return this.subtotal;
  }

  darTotal(){
    return this.subtotal+7000;
  }

  sumarCantidad(datoE: CarroCompras){
    for (var i = 0; i < this.listaCC.length; i++) {

      if(datoE == this.listaCC[i]){
        this.usuario.listaCC[i]._cantidad = datoE._cantidad +1;
        this.listaCC[i]._cantidad = this.usuario.listaCC[i]._cantidad;
      }
    }



    for(let aux of this.listaUsuarios)
    {
      if(this.usuario._email != aux._email){
        this.listaU2.push(aux);
      }else{
        this.listaU2.push(this.usuario);
      }
    }

    localStorage.setItem('localListaUsuarios',JSON.stringify(this.listaU2));
    this.listaU2 = [];

  }

  restarCantidad(datoE: CarroCompras){

    for (var i = 0; i < this.listaCC.length; i++) {

      if(datoE == this.listaCC[i]){
        if(this.usuario.listaCC[i]._cantidad  != 0){
          this.usuario.listaCC[i]._cantidad = datoE._cantidad -1;
          this.listaCC[i]._cantidad = this.usuario.listaCC[i]._cantidad;
        }
      }
    }

    for(let aux of this.listaUsuarios)
    {
      if(this.usuario._email != aux._email){
        this.listaU2.push(aux);
      }else{
        this.listaU2.push(this.usuario);
      }
    }

    localStorage.setItem('localListaUsuarios',JSON.stringify(this.listaU2));
    this.listaU2 = [];
  }

  borrarDato(datoE: CarroCompras){
     for (var i = 0; i < this.listaCC.length; i++) {

      if(datoE != this.listaCC[i]){ //Si la lista esta vacia
        this.listaCC2.push(this.listaCC[i]);
      }
    }

    this.usuario.listaCC = this.listaCC2;
    this.listaCC = this.listaCC2;
    this.listaCC2 = [];

    for(let aux of this.listaUsuarios)
    {
      if(this.usuario._email != aux._email){
        this.listaU2.push(aux);
      }else{
        this.listaU2.push(this.usuario);
      }
    }

    localStorage.setItem('localListaUsuarios',JSON.stringify(this.listaU2));
    this.listaU2 = [];

    window.location.reload();
  }

  pagar(){


    for (var i = 0; i < this.usuario.listaCC.length; i++) {
      this.usuario.ordenes.push(this.usuario.listaCC[i]);
    }

    this.listaCC = [];
    this.usuario.listaCC= this.listaCC;

    for(let aux of this.listaUsuarios)
   {
     if(this.usuario._email != aux._email){
       this.listaU2.push(aux);
     }else{
       this.listaU2.push(this.usuario);
     }
   }

   localStorage.setItem('localListaUsuarios',JSON.stringify(this.listaU2));

   alert("Su pago se realizó correctamente");
   this.listaU2 = [];
   this.actualizarFormulario();
   this.router.navigateByUrl("/ordenes");
 }

  actualizarFormulario(){
    var storageList = localStorage.getItem('localListaUsuarios');
    if(storageList== null){
      this.listaUsuarios = [];
    }
    else{
      this.listaUsuarios = JSON.parse(storageList);
    }

    this.buscarPersona(this.correoA);

  }

}