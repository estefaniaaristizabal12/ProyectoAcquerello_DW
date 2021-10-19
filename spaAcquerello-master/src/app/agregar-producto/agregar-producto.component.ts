import { Component, OnInit } from '@angular/core';
import { Plato } from '../model/plato';
import { PlatoService } from '../plato.service';

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
  
  constructor(public _platoService: PlatoService) { 
    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    }) ;
  }
  ngOnInit(): void {
  }
  agregarPlato(){
    this._platoService.createPlato(this.plato);
  }

  cerrar(){
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

}
