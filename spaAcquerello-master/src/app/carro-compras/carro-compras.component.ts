import { DatePipe } from '@angular/common';
import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarroComprasService } from '../carro-compras.service';
import { FacturaService } from '../factura.service';
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
  
  public listaCC: CarroCompras[] = [];
  public fechaL: Date = new Date();
  public factura: Factura = new Factura(0,0,0,this.fechaL,"");
  public usuario: Usuario = new Usuario(0,"","","","","","");
  public listaUsuarios: Usuario[] = [];
  public correoA:string ="";
  public numItems: number = 0;
  public total: number = 0;
  public subtotal: number = 0;
  public mostrar: boolean = false;
  public mostrarT: boolean = false;


  constructor(public _usuarioService: UsuarioService, public router: Router, public _carroCCService: CarroComprasService, public _platoService: PlatoService, public _facturaService: FacturaService) { 
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

    for(var i=0; i< this.listaCC.length; i++){
      this.factura= new Factura(0,this.listaCC[i]._cantidad, this.listaCC[i]._precio*this.listaCC[i]._cantidad,this.fechaL,this.listaCC[i]._foto );
      this.factura.nombrePlato = this.listaCC[i]._nombreProducto;
      //Se agrega ese carro de compras
      this._facturaService.createFactura(this.factura,this.correoA).subscribe(() =>{
      },() =>{
        alert("Error: No se pudo agregar la factura correctamente");
      });

    } 

    //Se borran todos los registros de CC

    this._carroCCService.deleteCarroUsuario(this.usuario._idUsuario).subscribe(() =>{
    },() =>{
      alert("ERROR: No se pudo realizar el pago!");
    });


    this.router.navigateByUrl("/ordenes");
 }

  

}
