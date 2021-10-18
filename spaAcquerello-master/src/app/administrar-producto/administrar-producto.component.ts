import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from '../model/plato';
import { PlatoService } from '../plato.service';

@Component({
  selector: 'app-administrar-producto',
  templateUrl: './administrar-producto.component.html',
  styleUrls: ['./administrar-producto.component.css']
})
export class AdministrarProductoComponent implements OnInit {

  public listaPlatos: Plato[] = [];
  public listaP2: Plato[] = [];
  public aux: Plato = new Plato(0,"","","",0);

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

  verProductoEditar( plato: Plato){
    this._platoService.platoObtener = plato;
    this.router.navigate(["editarProducto"])
  }
  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

  
  borrarDato(platoE: Plato){
    for (var i = 0; i < this.listaPlatos.length; i++) {
     if(platoE != this.listaPlatos[i]){ //Si la lista esta vacia
       this.listaP2.push(this.listaPlatos[i]);
       
     }
   }

   localStorage.setItem('localListaPlatos',JSON.stringify(this.listaP2));
   this.listaP2 = [];

   this.actualizar();
 }

 actualizar(){
  var storageList = localStorage.getItem('localListaPlatos');
  if(storageList== null){
    this.listaPlatos = [];
  }
  else{
    this.listaPlatos = JSON.parse(storageList);
  }
 }

}
