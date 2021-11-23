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

  public platoA:any;
  platoObtener: Plato = new Plato (0,'','','',0);
  aux: Plato = new Plato (0,'','','',0);
  public listaPlatos: Plato[] = [];


  constructor(public _platoService: PlatoService, private router:Router) {
    if(this._platoService.platoObtener)
      this.platoObtener = this._platoService.platoObtener;
   }

  ngOnInit(): void {
  }

  actualizar(){
    this.platoA = this.platoObtener;
    this._platoService.updatePlato(this.platoA).subscribe();
    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    });
    this.router.navigateByUrl("/administrarProductos");
  }

  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

}

