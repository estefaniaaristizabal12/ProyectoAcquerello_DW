import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarroCompras } from '../model/carroCompras';
import { Plato } from '../model/plato';
import { Usuario } from '../model/usuario';
import { PlatoService } from '../plato.service';

@Component({
  selector: 'app-reporte-ventas',
  templateUrl: './reporte-ventas.component.html',
  styleUrls: ['./reporte-ventas.component.css']
})
export class ReporteVentasComponent implements OnInit {

  public listaPlatos: Plato[] = [];
  public listaP2: Plato[] = [];
  public aux: Plato = new Plato("","","",0);
  public listaUsuarios: Usuario[] =[];
  public listaOrdenes: CarroCompras [] = [];
  public usuario: Usuario = new Usuario("","","","","","");
  public auxU: Usuario = new Usuario("","","","","","");
  public totalVendidos: number = 0; 
  public precioTotal: number = 0; 

  constructor( public _platoService: PlatoService, public router: Router ) {
    var storageList = localStorage.getItem('localListaPlatos');
    if(storageList== null){
      this.listaPlatos = [];
    }
    else{
      this.listaPlatos = JSON.parse(storageList);
    }

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
    var aux = localStorage.getItem('localListaUsuarios');
    if(aux == null){
      this.listaUsuarios = [];
    }else{
      this.listaUsuarios = JSON.parse(aux);
    }


    for(let auxU of this.listaUsuarios){
      this.listaOrdenes = auxU.ordenes;
      for(var i = 0; i < this.listaOrdenes.length; i++){
        if(plato._nombre == this.listaOrdenes[i]._nombreProducto){
          this.totalVendidos++;
        }
      }
    }

  }

  precioTotalF(plato: Plato){
    this.precioTotal = 0;
    this.precioTotal = plato._precio * this.totalVendidos;
  }



}