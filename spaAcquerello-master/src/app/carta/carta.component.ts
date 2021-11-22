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
  

  public plato: Plato = new Plato(0,"","","",0);
  public listaPlatos: Plato[] = [];
  public mostrar:boolean=true;
  public listaUsuarios: Usuario[] = [];
  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];
  public aux1: Usuario = new Usuario(0,"","","","","","");
  public admin: Usuario = new Usuario(0,"","","","","","");
  public carroCompras: CarroCompras =  new CarroCompras(0,"",0,0,"");
  public listaU2: Usuario[] = [];
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

    var aux = localStorage.getItem('actual');
    if(aux== null) this.correoA = "";
    else this.correoA = aux;

    //Se pide el usuario actual
    this._usuarioService.getUsuarioXEmail(this.correoA)
    .subscribe(data =>{
      this.usuario = data;
    }) ;

    var auxa= localStorage.getItem('administrador');
    if(auxa== null) this.admin = new Usuario(0,"","","","","","");
    else this.admin = JSON.parse(auxa);
    

    //Se validan los tipos de datos

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
      alert(platoE._nombre);
      this.carroCompras = new CarroCompras(0,platoE._nombre,1,platoE._precio, platoE._imagen);

      //Se inicializa el usuario en CC
      // this._usuarioService.getUsuarioXEmail(this.correoA)
      // .subscribe(data =>{
      //   this.carroCompras.usuarioC = data;
      // }) ;

      this._usuarioService.getUsuarioXEmail(this.correoA)
      .subscribe(data =>{
        this.carroCompras.usuarioC = data;
      });


  

      //Se inicializa el plato en CC
      this._platoService.getPlatoXNombre(platoE._nombre)
      .subscribe(data =>{
        this.carroCompras.platoC = data;
      }) ;

  
      //Se agrega ese carro de compras
      this._carroCCService.createCarroCompras(this.carroCompras).subscribe(() => {
        alert("Se agregó al carrito de compras correctamente!");
      }, () => {
        alert("Error: no se pudo agregar correctamente");
      });
     
   }

  }
}
