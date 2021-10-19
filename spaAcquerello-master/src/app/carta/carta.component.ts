import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { __values } from 'tslib';
import { CarroCompras } from '../model/carroCompras';
import { Plato } from '../model/plato';
import { Usuario } from '../model/usuario';
import { PlatoService } from '../plato.service';

@Component({
  selector: 'app-carta',
  templateUrl: './carta.component.html',
  styleUrls: ['./carta.component.css']
})
export class CartaComponent implements OnInit {
  

  public plato: Plato = new Plato(0,"","","",0);
  public listaPlatos: Plato[] = [];
  public mostrar:boolean=true;
  public listaUsuarios: Usuario[] = [];
  public aux1: Usuario = new Usuario(0,"","","","","");
  public admin: Usuario = new Usuario(0,"","","","","");
  public carroCompras: CarroCompras =  new CarroCompras(0,"",0,0,"");
  public listaU2: Usuario[] = [];
  public listacarroCompras: CarroCompras[] = [];
  public usuario: Usuario = new Usuario(0,"","","","","");
  public correoA:string ="";
  public validacion: boolean = false;
  public vAdmon: boolean = false;

  constructor( public _platoService: PlatoService, public router: Router ) { 
    var aux = localStorage.getItem('localListaPlatos');

    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    }) ;

    this.async_print_personas();
    
  

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
      this.admin = new Usuario(0,"","","","","");
    }
    else{
      this.admin = JSON.parse(auxa);
    }

    if(this.correoA == ""){
      this.validacion =false;
    }
    else if(this.admin._email == this.correoA){
      this.validacion = false;
      this.vAdmon = true;
    }
    else{
      this.validacion = true;
    }

  }

  async async_print_personas() {
    await new Promise((f) => setTimeout(f, 1000));
    console.log(this.listaPlatos);
  }

  ngOnInit(): void {
  }

  verProducto( plato: Plato){
    this._platoService.platoObtener = plato;
    this.router.navigateByUrl("/infoPlato");
  }

  
  agregarProductoCC(platoE:Plato){

    if(this.validacion ==false && this.vAdmon == false){
      alert("No se puede añadir al carrito, inicie sesión....");
      this.router.navigateByUrl("iniciarSesion");
    }
    else if(this.validacion ==false && this.vAdmon == true){
      alert("No se pueden realizar pedidos desde el administrador!");
    }
    else{

    this.listacarroCompras = this.usuario.carroCompras;
    this.carroCompras = new CarroCompras(0,platoE._nombre,1,platoE._precio, platoE._imagen);
    this.listacarroCompras.push(this.carroCompras);
    this.usuario.carroCompras = this.listacarroCompras;

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
