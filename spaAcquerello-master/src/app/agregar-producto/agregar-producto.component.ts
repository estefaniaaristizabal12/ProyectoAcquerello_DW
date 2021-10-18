import { Component, OnInit } from '@angular/core';
import { Plato } from '../model/plato';

@Component({
  selector: 'app-agregar-producto',
  templateUrl: './agregar-producto.component.html',
  styleUrls: ['./agregar-producto.component.css']
})
export class AgregarProductoComponent implements OnInit {

  public foto:string="";
  public listaPlatos: Plato[] = [];
  public listaP2: Plato[] = [];
  public plato: Plato = new Plato(0,"","","assets/imagenVacia.png",0);
  
  constructor() { 
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

  agregarPlato(){
    this.listaPlatos.push(this.plato);
    localStorage.setItem('localListaPlatos',JSON.stringify(this.listaPlatos));
    alert("El plato "+this.plato._nombre+" , se agregó correctamente");
    window.location.reload();
  }

  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

}
