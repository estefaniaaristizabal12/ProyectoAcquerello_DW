import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { __values } from 'tslib';
import { CarroCompras } from '../model/carroCompras';
import { Factura } from '../model/factura';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-registrarse',
  templateUrl: './registrarse.component.html',
  styleUrls: ['./registrarse.component.css']
})
export class RegistrarseComponent implements OnInit {

  public usuario: Usuario = new Usuario(0,"","","","","","usuario");
  public listaUsuarios: Usuario[] = [];

  constructor( public _usuarioService: UsuarioService, public router: Router ) { 
    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;

  }
  ngOnInit(): void {
  }

  agregarUsuario(){
  
    this._usuarioService.createUsuario(this.usuario).subscribe(() => {
      alert("El usuario se registro correctamente!");
      this.irAMiCuenta();
    }, () => {
      alert("Error: no se pudo registrar correctamente");
    });

  }

  irAMiCuenta(){
    this.router.navigateByUrl("/iniciarSesion");
  }

}

