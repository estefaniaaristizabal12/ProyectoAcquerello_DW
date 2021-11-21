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
  public listaP2: Plato[] = [];

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

    this.async_print_personas();
    this.router.navigateByUrl("/administrarProductos");

  }

  async async_print_personas() {
    await new Promise((f) => setTimeout(f, 1000));
    console.log(this.listaPlatos);
  }

  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

}

