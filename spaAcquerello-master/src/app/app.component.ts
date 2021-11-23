import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { CarroCompras } from './model/carroCompras';
import { Factura } from './model/factura';
import { Plato } from './model/plato';
import { Usuario } from './model/usuario';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'spaAcquerello';
}
