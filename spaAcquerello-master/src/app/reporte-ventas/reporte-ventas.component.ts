import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FacturaService } from '../factura.service';
import { CarroCompras } from '../model/carroCompras';
import { Factura } from '../model/factura';
import { Plato } from '../model/plato';
import { Usuario } from '../model/usuario';
import { PlatoService } from '../plato.service';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-reporte-ventas',
  templateUrl: './reporte-ventas.component.html',
  styleUrls: ['./reporte-ventas.component.css']
})
export class ReporteVentasComponent implements OnInit {

  public fechaL: Date = new Date();
  public factura: Factura = new Factura(0,0,0,this.fechaL,"");
  public listaPlatos: Plato[] = [];
  public listaUsuarios: Usuario[] =[];
  public listaOrdenes: Factura [] = [];
  public usuario: Usuario = new Usuario(0,"","","","","","");
  public totalVendidos: number = 0; 
  public precioTotal: number = 0; 

  constructor( public _platoService: PlatoService, public router: Router, public _usuarioService: UsuarioService, public _facturaService: FacturaService ) {
    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    }) ;

    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;

    this._facturaService.getlistaFactura().subscribe(data3 =>{
      this.listaOrdenes = data3;
    },() =>{
      alert("ERROR: Se generó un error los datos de las facturas");
    });

  }

  ngOnInit(): void {
  }

  verProducto( plato: Plato){
    this._platoService.platoObtener = plato;
    this.router.navigate(["infoPlato"])
  }
  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }


  totalVendidosF(plato: Plato){
    this.totalVendidos = 0;
    for(var i = 0; i < this.listaOrdenes.length; i++){
      this.factura = this.listaOrdenes[i];
      if(this.factura.nombrePlato == plato._nombre){
        this.totalVendidos = this.totalVendidos + this.factura.cantidad;
      }
    }

  }

  precioTotalF(plato: Plato){
    this.precioTotal = 0;
    this.precioTotal = plato._precio * this.totalVendidos;
  }
}
