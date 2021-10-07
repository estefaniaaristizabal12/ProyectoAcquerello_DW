import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plato } from '../model/plato';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  public plato1: Plato = new Plato("","","",0);
  public plato2: Plato = new Plato("","","",0);
  public plato3: Plato = new Plato("","","",0);

  public listaPlatos: Plato[] = [];
  
  constructor(public route: Router) { 
    var aux = localStorage.getItem('localListaPlatos');
    if(aux== null){
      this.listaPlatos = [];
    }
    else{
      this.listaPlatos =  JSON.parse(aux);
    }

    if(this.listaPlatos.length >= 3){
    this.plato1 = this.listaPlatos[0];
    this.plato2 = this.listaPlatos[1];
    this.plato3 = this.listaPlatos[2];
    }

  }

  ngOnInit(): void {
  }


  enviarCarta(){
    this.route.navigateByUrl("/carta");
  }

}
