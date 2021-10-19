import { CarroCompras } from "./carroCompras";

export class Usuario {
    public _idUsuario: number = 0;
    public _email: string = "";
    public _nombre: string = "";
    public _apellido: string = "";
    public _direccion: string = "";
    public _contrasenia: string = "";
    public carroCompras: CarroCompras[] = [];
    public facturas: CarroCompras[] = [];
    constructor(idUsuario:number, nombre:string, apellido:string,  email:string, 
         contrasenia:string,  direccion:string){
            this._idUsuario = idUsuario;
            this._email = email;
            this._nombre = nombre;
            this._apellido = apellido;
            this._direccion = direccion;
            this._contrasenia = contrasenia;        
    }
}