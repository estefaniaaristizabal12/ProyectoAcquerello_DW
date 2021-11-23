import { DatePipe } from '@angular/common';
import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarroComprasService } from '../carro-compras.service';
import { CarroCompras } from '../model/carroCompras';
import { Factura } from '../model/factura';
import { Usuario } from '../model/usuario';
import { PlatoService } from '../plato.service';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-carro-compras',
  templateUrl: './carro-compras.component.html',
  styleUrls: ['./carro-compras.component.css']
})
export class CarroComprasComponent implements OnInit {
  
  listaCC: CarroCompras[] = [];
  listaCC2: CarroCompras[] = [];
  facturaN: Factura [] = [];
  fechaL: Date = new Date();
  factAux: Factura = new Factura(0,0,0,this.fechaL,"");
  dato: CarroCompras = new CarroCompras(0,"",0,0,"");
  aux2: CarroCompras = new CarroCompras(0,"",0,0,"");
  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];
  idUsuario: number = 0;
  public usuario: Usuario = new Usuario(0,"","","","","","");
  public aux: Usuario = new Usuario(0,"","","","","","");
  public listaUsuarios: Usuario[] = [];
  public listaU2: Usuario[] = [];
  public correoA:string ="";
  public numItems: number = 0;
  public total: number = 0;
  public subtotal: number = 0;
  public mostrar: boolean = false;
  public mostrarT: boolean = false;




  constructor(public _usuarioService: UsuarioService,public router: Router, public _carroCCService: CarroComprasService, public _platoService: PlatoService) { 
    this.total = 0;

    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;

    //Información del usuario actual
    var aux = localStorage.getItem('actual');
    if(aux== null) this.correoA = "";
    else this.correoA = aux;
    
    //Se obtiene la información del usuario actual
    this._usuarioService.getUsuarioXEmail(this.correoA)
    .subscribe(data =>{
      this.usuario = data;
    },() =>{
      alert("ERROR: Se generó un error cargando el carro de compras.");
    },() =>{
      this.pedirCarroCompras()
    }) ;
 
  }

  pedirCarroCompras(){
    this._carroCCService.getlistaCarroComprasXIdUsuario(this.usuario._idUsuario).subscribe(data3 =>{
      this.listaCC = data3;
    },() =>{
      alert("ERROR: Se generó un error cargando el carro de compras.");
    },() =>{
      this.modificarDatos()
    });
  }

  modificarDatos(){
    if(this.listaCC.length>0) this.mostrar =  true;
    else this.mostrarT = true;

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
      this.subtotal = this.subtotal + dato._cantidad * dato._precio;
    
    return this.subtotal;
  }

  darTotal(){
    return this.subtotal+7000;
  }

  sumarCantidad(datoE: CarroCompras){

    //Se pide la información del plato y del usuario

    datoE.usuarioc = this.usuario;
    this._platoService.getPlatoXNombre(datoE._nombreProducto)
    .subscribe(data =>{
      datoE.platoc = data;
    },() =>{
      alert("ERROR: No se pudo obtener el plato");
    }) ;

    //Se actualiza la base de datos

    datoE._cantidad = datoE._cantidad+1;
    this._carroCCService.updateCarroCompras(datoE).subscribe(() =>{
    },() =>{
      alert("ERROR: No se pudo modificar la cantidad");
    });

  }

  restarCantidad(datoE: CarroCompras){

    //Se pide la información del plato y del usuario

    datoE.usuarioc = this.usuario;
    this._platoService.getPlatoXNombre(datoE._nombreProducto)
    .subscribe(data =>{
      datoE.platoc = data;
    },() =>{
      alert("ERROR: No se pudo obtener el plato");
    }) ;

    //Se actualiza la base de datos

    datoE._cantidad = datoE._cantidad-1;
    this._carroCCService.updateCarroCompras(datoE).subscribe(() =>{
    },() =>{
      alert("ERROR: No se pudo modificar la cantidad");
    });

  }

  borrarDato(datoE: CarroCompras){

    //Se elimina el producto de la base de datos

    this._carroCCService.deleteProductoCarro(datoE._id_CC).subscribe(() =>{
      alert("Este producto se eliminó correctamente del carro de compras");
    },() =>{
      alert("ERROR: No se pudo eliminar el producto del carro de compras.");
    });
    window.location.reload();
  }

  pagar(){

    for (var i = 0; i < this.usuario.carroCompras.length; i++) {
      this.factAux.cantidad = this.usuario.carroCompras[i]._cantidad;
      this.factAux.total = this.usuario.carroCompras[i]._precio * this.usuario.carroCompras[i]._cantidad;
      this.factAux.idFactura = 555;
      this.factAux.fecha = this.fechaL;
      this.usuario.facturas.push(this.factAux);

    }

    /*for (var i = 0; i < this.usuario.carroCompras.length; i++) {
      this.usuario.facturas.push(this.usuario.carroCompras[i]);
    }*/

    this.listaCC = [];
    this.usuario.carroCompras= this.listaCC;

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
