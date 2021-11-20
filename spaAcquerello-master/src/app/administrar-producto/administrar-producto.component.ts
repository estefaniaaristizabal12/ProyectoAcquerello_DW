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
    alert("Mira"+platoE._nombre);
    this._platoService.deletePlato(platoE._idPlato).subscribe();


    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    }) ;

    this.async_print_personas();


    //this.actualizar();
 }

 async async_print_personas() {
  await new Promise((f) => setTimeout(f, 1000));
  console.log(this.listaPlatos);
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
