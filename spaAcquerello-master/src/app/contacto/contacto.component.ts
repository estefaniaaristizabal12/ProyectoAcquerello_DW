import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contactanos } from '../model/contactanos';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})
export class ContactoComponent implements OnInit {


  public contacto: Contactanos = new Contactanos("","","","");
  public listaCont: Contactanos[] = [];


  constructor(public router: Router ) { }

  ngOnInit(): void {
  }

  contactanosSubmit(){

    var aux = localStorage.getItem('contactanos');

    if(aux == null){
      this.listaCont = [];
    }else{
      this.listaCont = JSON.parse(aux);
    }

    this.listaCont.push(this.contacto);

    localStorage.setItem('contactanos', JSON.stringify(this.listaCont));

    alert("Su mensaje se envió correctamente");

    window.location.reload();
  

  }


}
