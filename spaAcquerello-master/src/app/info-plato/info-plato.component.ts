import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { __values } from 'tslib';
import { CarroCompras } from '../model/carroCompras';
import { Plato } from '../model/plato';
import { Usuario } from '../model/usuario';
import { PlatoService } from '../plato.service';


@Component({
  selector: 'app-info-plato',
  templateUrl: './info-plato.component.html',
  styleUrls: ['./info-plato.component.css']
})
export class InfoPlatoComponent implements OnInit {

  platoObtener: Plato = new Plato ('','','',0);
  public plato: Plato = new Plato("","","",0);
  public listaPlatos: Plato[] = [];
  public mostrar:boolean=true;
  public listaUsuarios: Usuario[] = [];
  public aux1: Usuario = new Usuario("","","","","","");
  public carroCompras: CarroCompras =  new CarroCompras("",0,0,"");
  public listaU2: Usuario[] = [];
  public listacarroCompras: CarroCompras[] = [];
  public usuario: Usuario = new Usuario("","","","","","");
  public admin: Usuario = new Usuario("","","","","","")
  public correoA:string ="";
  public validacion: boolean = false;

  constructor(public _servicioProducto: PlatoService, private router:Router) {

      if(this._servicioProducto.platoObtener)
          this.platoObtener = this._servicioProducto.platoObtener;


      var aux = localStorage.getItem('localListaPlatos');
      if(aux== null){
        this.listaPlatos = [];
      }
      else{
        this.listaPlatos =  JSON.parse(aux);
      }
  
      var storageList = localStorage.getItem('localListaUsuarios');
      if(storageList== null){
        this.listaUsuarios = [];
      }
      else{
        this.listaUsuarios = JSON.parse(storageList);
      }
  
      this.darCorreo();
      this.buscarPersona(this.correoA);

     
      var auxa= localStorage.getItem('administrador');

      if(auxa== null){
        this.admin = new Usuario("","","","","","");
      }
      else{
        this.admin = JSON.parse(auxa);
      }

      if(this.correoA == ""){
        this.validacion =false;
      }
      else if(this.admin._email == this.correoA){
        this.validacion = false;
      }
      else{
        this.validacion = true;
      }
  }
  ngOnInit(): void {
  }

  agregarProducto(){
    if(this.validacion ==false){
      alert("No se puede añadir al carrito, inicie sesión....");
      this.router.navigateByUrl("/iniciarSesion");
    }

    else{
    this.listacarroCompras = this.usuario.listaCC;
    this.carroCompras = new CarroCompras(this.platoObtener._nombre,1,this.platoObtener._precio, this.platoObtener._imagen);
    this.listacarroCompras.push(this.carroCompras);
    this.usuario.listaCC = this.listacarroCompras;

    for(let aux1 of this.listaUsuarios)
    {
      if(this.usuario._email != aux1._email){
        this.listaU2.push(aux1);
      }else{
        this.listaU2.push(this.usuario);
      }
    }

    localStorage.setItem ('localListaUsuarios',JSON.stringify(this.listaU2));
    this.listaU2 = [];

    alert("Se agregó al carrito de compras correctamente!");
   }
  }


  
  buscarPersona(correoA:string){
    for(let aux of this.listaUsuarios)
    {
      if(correoA == aux._email){
        this.usuario = aux;
      }
    }
  }

  darCorreo(){
    var aux = localStorage.getItem('actual');
    //Se debe validar que no sea nulo el string.
    if(aux== null){
      this.correoA = "";
    }
    else{
      this.correoA = aux;
    }
  }




}
