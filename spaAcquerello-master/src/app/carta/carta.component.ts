import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { __values } from 'tslib';
import { CarroComprasService } from '../carro-compras.service';
import { CarroCompras } from '../model/carroCompras';
import { Factura } from '../model/factura';
import { Plato } from '../model/plato';
import { Usuario } from '../model/usuario';
import { PlatoService } from '../plato.service';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-carta',
  templateUrl: './carta.component.html',
  styleUrls: ['./carta.component.css']
})
export class CartaComponent implements OnInit {
  

  public listaPlatos: Plato[] = [];
  public mostrar:boolean=true;
  public listaUsuarios: Usuario[] = [];
  public admin: Usuario = new Usuario(0,"","","","","","");
  public carroCompras: CarroCompras =  new CarroCompras(0,"",0,0,"");
  public listacarroCompras: CarroCompras[] = [];
  public usuario: Usuario = new Usuario(0,"","","","","","");
  public correoA:string ="";
  public validacion: boolean = false;
  public vAdmon: boolean = false;


  constructor( public _platoService: PlatoService, public router: Router, public _usuarioService: UsuarioService, public _carroCCService: CarroComprasService ) { 

    this._platoService.getlistaPlato()
    .subscribe(data =>{
      this.listaPlatos = data;
    }) ;

    this._usuarioService.getlistaUsuario()
    .subscribe(data =>{
      this.listaUsuarios = data;
    }) ;

    this.darCorreo();
    this.buscarPersona(this.correoA);


    var auxa= localStorage.getItem('administrador');
    if(auxa== null){
      this.admin = new Usuario(0,"","","","","","");
    }
    else{
      this.admin = JSON.parse(auxa);
    }

    if(this.correoA == ""){
      this.validacion =false;
    }
    else if(this.admin._email == this.correoA){
      this.validacion = false;
      this.vAdmon = true;
    }
    else{
      this.validacion = true;
    }

  }


  ngOnInit(): void {
  }

  verProducto( plato: Plato){
    this._platoService.platoObtener = plato;
    this.router.navigateByUrl("/infoPlato");
  }


  agregarProductoCC(platoE:Plato){

    if(this.validacion ==false && this.vAdmon == false){
      alert("No se puede añadir al carrito, inicie sesión....");
      this.router.navigateByUrl("iniciarSesion");
    }
    else if(this.validacion ==false && this.vAdmon == true){
      alert("No se pueden realizar pedidos desde el administrador!");
    }
    else{

    this.listacarroCompras = this.usuario.carroCompras;
    this.carroCompras = new CarroCompras(0,platoE._nombre,1,platoE._precio, platoE._imagen);

  
    //Se agrega ese carro de compras
    this._carroCCService.createCarroCompras(this.carroCompras,this.correoA).subscribe(() =>{
      alert("Se agregó al carrito de compras correctamente!");
    },() =>{
      alert("Error: No se pudo agregar correctamente");
    });
   }

  }

  buscarPersona(correoA:string){
    for(let aux of this.listaUsuarios)
    {
      if(correoA == aux._email){
        this.usuario = aux;
      }
    }
  }

  darCorreo(){
    var aux = localStorage.getItem('actual');
    //Se debe validar que no sea nulo el string.
    if(aux== null){
      this.correoA = "";
    }
    else{
      this.correoA = aux;
    }
  }

  
}
