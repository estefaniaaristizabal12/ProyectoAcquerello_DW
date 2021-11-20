import { Component, OnInit, Output,EventEmitter} from '@angular/core';
import { Router } from '@angular/router';
import { CarroCompras } from '../model/carroCompras';
import { Factura } from '../model/factura';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {

  public email: string = "";
  public contrasenia: string = "";
  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];
  public usuario: Usuario = new Usuario(0,"","","","","","");
  public admin: Usuario = new Usuario(0,"","","","","","");
  public listaUsuarios: Usuario[] = [];
  constructor( public _usuarioService: UsuarioService, public router: Router ) { 
    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;

    this.async_print_personas();
    
  }
  //@Output() informacionUsuario: EventEmitter<Usuario>= new EventEmitter();
  ngOnInit(): void {
  }

  async async_print_personas() {
    await new Promise((f) => setTimeout(f, 1000));
    console.log(this.listaUsuarios);
  }

  inicioSesionSubmit(){




    var aux = localStorage.getItem('administrador');
    //Se debe validar que no sea nulo el string.
    if(aux== null){
      this.admin = new Usuario(0,"","","","","","");
    }
    else{
      this.admin =  JSON.parse(aux);
    }

/*
    if(this.email!= null && this.contrasenia != null && this.admin._email == this.email && this.admin._contrasenia == this.contrasenia){
      alert("Bienvenido "+this.admin._nombre);
      localStorage.setItem('actual',this.admin._email);
      this.dirigirInicioAdmon();
    } */
    if(this.email!= null && this.contrasenia != null && this._usuarioService.buscarPersona(this.email) == true){
      alert("entro al primero");
      if(this._usuarioService.verificarContrasenia(this.email, this.contrasenia)){

        if(this._usuarioService.darRol(this.email) == "administrador"){
          this.usuario = this._usuarioService.darUsuario(this.email);
          localStorage.setItem('administrador', JSON.stringify(this.usuario));
          alert("Bienvenido "+this.usuario._nombre);
          this.dirigirInicioAdmon();

        } else if(this._usuarioService.darRol(this.email) == "usuario"){
          this.usuario = this._usuarioService.darUsuario(this.email);
          alert("Bienvenido "+this.usuario._nombre);
          this.dirigirInicio();
        } else{
          alert("Se genero un error, intente más tarde... "+this.usuario._nombre);
        }  
      }
      else{
        alert("Contraseña incorrecta");
      }
    }
    else{
      alert("No se encontro usuario");
    }


  }

  dirigirInicio(){
    this.router.navigateByUrl('/miCuenta'); 
  }

  dirigirInicioAdmon(){
    this.router.navigateByUrl('/perfilAdmin'); 
  }


}
