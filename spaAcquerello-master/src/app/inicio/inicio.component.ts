import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from '../model/plato';
import { PlatoService } from '../plato.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  i:number =0;
  public plato: Plato = new Plato(0,"","","",0);
  public plato1: Plato = new Plato(0,"","","",0);
  public plato2: Plato = new Plato(0,"","","",0);
  public plato3: Plato = new Plato(0,"","","",0);

  public listaPlatos: Plato[] = [];
  
  constructor(private _platoService: PlatoService, public route: Router) { 

    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    }) ;

    this.ngOnInit();
  }


  ngOnInit(): void {
  }

  enviarCarta(){
    this.route.navigateByUrl("/carta");
  }

}
