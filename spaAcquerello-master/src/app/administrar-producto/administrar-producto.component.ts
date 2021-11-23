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

  constructor( public _platoService: PlatoService, public router: Router ) {
    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    }) ;
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
    this._platoService.deletePlato(platoE._idPlato).subscribe();
    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    }) ;
  }


}
