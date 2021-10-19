import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { __values } from 'tslib';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-registrarse',
  templateUrl: './registrarse.component.html',
  styleUrls: ['./registrarse.component.css']
})
export class RegistrarseComponent implements OnInit {

  public usuario: Usuario = new Usuario(0,"","","","","");
  constructor( public _usuarioService: UsuarioService, public router: Router ) { }

  ngOnInit(): void {
  }

  registroSubmit(){
    this._usuarioService.agregar(this.usuario);
    this.usuario = new Usuario(0,"","","","","cliente");
    alert("lol:" + this.usuario._nombre + " " +this.usuario._apellido);
  }

}

