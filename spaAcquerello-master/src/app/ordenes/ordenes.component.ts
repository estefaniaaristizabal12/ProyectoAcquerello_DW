import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { FacturaService } from '../factura.service';
import { CarroCompras } from '../model/carroCompras';
import { Factura } from '../model/factura';
import { Usuario } from '../model/usuario';
import { PlatoService } from '../plato.service';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-ordenes',
  templateUrl: './ordenes.component.html',
  styleUrls: ['./ordenes.component.css']
})
export class OrdenesComponent implements OnInit {

  listaOrdenes: Factura[] = [];
  fechaL: Date = new Date();
  dato: Factura = new Factura(0,0,0,this.fechaL,"");
  nombreProducto: String = "";
  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];
  public usuario: Usuario = new Usuario(0,"","","","","","");
  public aux: Usuario = new Usuario(0,"","","","","","");
  public listaUsuarios: Usuario[] = [];
  public correoA:string ="";


  constructor(public _usuarioService: UsuarioService, public router: Router, public _platoService: PlatoService, public _facturaService: FacturaService) { 
    var aux1 = localStorage.getItem('actual');
    if(aux1== null) this.correoA = "";
    else this.correoA = aux1;
  
    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;

  


    //Se obtiene la información del usuario actual
    this._usuarioService.getUsuarioXEmail(this.correoA)
    .subscribe(data =>{
      alert("Gracias por su compra en Acquerello Ristorante!");
      this.usuario = data;
    },() =>{
      alert("ERROR: Se generó un error en el pago.");
    },() =>{
      this.obtenerListaOrdenes();
    }) ;

    
  }

  obtenerListaOrdenes(){
    this._facturaService.getlistaFacturasXIdUsuario(this.usuario._idUsuario).subscribe(data3 =>{
      this.listaOrdenes = data3;
    },() =>{
      alert("ERROR: Se generó un error los datos de las facturas");
    });
  }

  ngOnInit(): void {
  }

 
  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

  



}
