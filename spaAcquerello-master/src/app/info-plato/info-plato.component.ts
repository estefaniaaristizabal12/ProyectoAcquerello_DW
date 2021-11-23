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
  selector: 'app-info-plato',
  templateUrl: './info-plato.component.html',
  styleUrls: ['./info-plato.component.css']
})
export class InfoPlatoComponent implements OnInit {

  platoObtener: Plato = new Plato (0,"","","",0);
  public plato: Plato = new Plato(0,"","","",0);
  public platoE: Plato = new Plato(0,"","","",0);
  public listaPlatos: Plato[] = [];
  public mostrar:boolean=true;
  public listaUsuarios: Usuario[] = [];
  auxx: CarroCompras[] = [];
  auxxf: Factura [] = [];
  public aux1: Usuario = new Usuario(0,"","","","","","");
  public carroCompras: CarroCompras =  new CarroCompras(0,"",0,0,"");
  public listaU2: Usuario[] = [];
  public listacarroCompras: CarroCompras[] = [];
  public usuario: Usuario = new Usuario(0,"","","","","","");
  public admin: Usuario = new Usuario(0,"","","","","","");
  public correoA:string ="";
  public validacion: boolean = false;
  public vAdmon: boolean = false;

  constructor(public _platoService: PlatoService, private router:Router, public _usuarioService: UsuarioService, public _carroCCService: CarroComprasService ) {

    if(this._platoService.platoObtener)
          this.platoObtener = this._platoService.platoObtener;

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

  agregarProducto(){

    if(this.validacion ==false && this.vAdmon == false){
      alert("No se puede añadir al carrito, inicie sesión....");
      this.router.navigateByUrl("iniciarSesion");
    }
    else if(this.validacion ==false && this.vAdmon == true){
      alert("No se pueden realizar pedidos desde el administrador!");
    }
    else{

    this.listacarroCompras = this.usuario.carroCompras;
    this.carroCompras = new CarroCompras(0,this.platoObtener._nombre,1,this.platoObtener._precio, this.platoObtener._imagen);

  
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
    if(aux== null) this.correoA = "";
    else this.correoA = aux;
  }




}
