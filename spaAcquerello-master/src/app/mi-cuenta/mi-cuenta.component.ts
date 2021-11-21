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

    
  }


  // constructor(private router:Router, public _usuarioService: UsuarioService ) { 

  //   this._usuarioService.getlistaUsuario()
  //   .subscribe(data =>{
  //     this.listaUsuarios = data;
  //   }) ;


  //   for(let usuario of this.listaUsuarios)
  //   {
  //     alert("SAPOOO "+ usuario._nombre);
  //   }


  //   this.async_print_personas();

  //   var aux = localStorage.getItem('actual');
  //   if(aux== null) this.correoA = "";
  //   else this.correoA = aux;

  //   this.buscarPersona(this.correoA);
  // }

  async async_print_personas() {
    await new Promise((f) => setTimeout(f, 1000));
    console.log(this.listaUsuarios);
  }

  ngOnInit(): void {
  }

  buscarPersona(correoA:string){
    for(let aux of this.listaUsuarios)
    {
      alert("mira "+aux._email);
      if(correoA == aux._email){
        alert("Holiii, entre aca xd ");
        this.usuario = aux;
      }
    }
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
    this._usuarioService.updateUsuario(this.usuario).subscribe();
    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    });

    this.router.navigateByUrl("/miCuenta");
  }
}
