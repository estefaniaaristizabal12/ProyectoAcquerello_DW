import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { __values } from 'tslib';
import { Plato } from '../model/plato';
import { PlatoService } from '../plato.service';


@Component({
  selector: 'app-editar-producto',
  templateUrl: './editar-producto.component.html',
  styleUrls: ['./editar-producto.component.css']
})
export class EditarProductoComponent implements OnInit {



  platoObtener: Plato = new Plato (0,'','','',0);
  aux: Plato = new Plato (0,'','','',0);
  public listaPlatos: Plato[] = [];
  public listaP2: Plato[] = [];

  constructor(public _servicioProducto: PlatoService, private router:Router) {

      if(this._servicioProducto.platoObtener)
          this.platoObtener = this._servicioProducto.platoObtener;
   }

  ngOnInit(): void {
  }

  actualizar(){

    var aux1 = localStorage.getItem('localListaPlatos');
    //Se debe validar que no sea nulo el string.
    if(aux1== null){
      this.listaPlatos=[];
    }
    else{
      this.listaPlatos = JSON.parse(aux1);
    }

    
    for(let aux of this.listaPlatos)
    {
      if(this.platoObtener._nombre != aux._nombre){
        this.listaP2.push(aux);
      }else{
        this.listaP2.push(this.platoObtener);
      }
    }

    localStorage.setItem('localListaPlatos',JSON.stringify(this.listaP2));
    this.listaP2=[];

    this.router.navigateByUrl("/administrarProductos");

  }

  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

}

