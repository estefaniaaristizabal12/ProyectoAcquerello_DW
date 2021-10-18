import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Plato } from './model/plato';
import { Usuario } from './model/usuario';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'spaAcquerello';
  public listaPlato: Plato [] = [];
  public listaPlato2: Plato [] = [];
  public admin: Usuario = new Usuario("","","","","","");
  public admin2: Usuario = new Usuario("Acquerello", "Ristorante", "acquerello@ristorante.com","admin12345","Cl. 122 #15a-24","administrador");
  constructor() { 
    let producto1:Plato = new Plato(1,'Pasta Al Pomodoro Fresco', 'Clásica salsa pomodoro, albahaca y aceite de oliva.','assets/plato1.jpg', 19000);
    let producto2:Plato = new Plato(2,'Pasta Al Funghi', 'Salsa cremosa de hongos con adicion de especies y parmigiano.','assets/plato2.jpg', 12000);
    let producto3:Plato = new Plato(3,'Pasta Vegetariana', 'Cremosa salsa de vegetales: calabacines, hongos, ceboll.','assets/plato3.jpg', 13000);
    let producto4:Plato = new Plato(4,'Pizza Burrata', 'Burrata fresca de búfala con adición parmigiano y pimienta.','assets/plato5.jpg', 12000);
    let producto5:Plato = new Plato(5,'Pizza Margarita', 'Bocconcini, queso mozzarella, albahaca y pimienta.','assets/plato5.jpg', 16000);
    let producto6:Plato = new Plato(6,'Pizza Quattro Formago', 'Bocconcini, queso azul, pecorino y láminas crujiente.','assets/plato6.jpg', 18000);

    this.listaPlato.push(producto1);
    this.listaPlato.push(producto2);
    this.listaPlato.push(producto3);
    this.listaPlato.push(producto4);
    this.listaPlato.push(producto5);
    this.listaPlato.push(producto6);

    var aux = localStorage.getItem('administrador');
     //Aca valida, si ya existe administrador en el sistema mete el que esta por defecto y si no, lo mantiene
    if(aux== null){
      this.admin = this.admin2;
    }
    else{
      this.admin = JSON.parse(aux);
    }
    localStorage.setItem('administrador', JSON.stringify(this.admin));

    //Aca valida, si ya existen platos en el sistema mete los que estan por defecto y si no, los mantiene

    var aux2 = localStorage.getItem('localListaPlatos');
    if(aux2== null){
      this.listaPlato2 = this.listaPlato;
    }
    else{
      this.listaPlato2 = JSON.parse(aux2);
    }

    localStorage.setItem('localListaPlatos', JSON.stringify(this.listaPlato2));
  }  

}
