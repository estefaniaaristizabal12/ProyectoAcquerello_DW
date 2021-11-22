import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarroCompras } from '../model/carroCompras';
import { Factura } from '../model/factura';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-mi-cuenta',
  templateUrl: './mi-cuenta.component.html',
  styleUrls: ['./mi-cuenta.component.css']
})

export class MiCuentaComponent implements OnInit {

  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];
  public usuario: Usuario = new Usuario(0,"","","","","","");
  public aux: Usuario = new Usuario(0,"","","","","","");
  public listaUsuarios: Usuario[] = [];
  public listaU2: Usuario[] = [];
  public correoA:string ="";
  public numItems: number = 0;

  constructor( public _usuarioService: UsuarioService, public router: Router ) { 
    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;

    this.async_print_personas();

    var aux = localStorage.getItem('actual');
    if(aux== null) this.correoA = "";
    else this.correoA = aux;

    this._usuarioService.getUsuarioXEmail(this.correoA)
    .subscribe(data =>{
      this.usuario = data;
    }) ;
    
  }


  async async_print_personas() {
    await new Promise((f) => setTimeout(f, 1000));
    console.log(this.listaUsuarios);
  }

  ngOnInit(): void {
  }


  darNumItem(){
    return this.numItems;
  }

  cerrar(){
    //borro el inicio
    localStorage.setItem('actual',"");
    alert("Se cerró sesión correctamente!");
  }

  actualizar(){
    this._usuarioService.updateUsuario(this.usuario).subscribe(() => {
      alert("Se actualizó correctamente la información!");
    }, () => {
      alert("ERROR: no se pudo actualizar la información.");
    });
    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    });
    this.router.navigateByUrl("/miCuenta");
  }
}
