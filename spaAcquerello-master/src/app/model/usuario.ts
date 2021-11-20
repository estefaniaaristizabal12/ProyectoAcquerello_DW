import { CarroCompras } from "./carroCompras";
import { Factura } from "./factura";

export class Usuario {
    public _idUsuario: number = 0;
    public _email: string = "";
    public _nombre: string = "";
    public _apellido: string = "";
    public _direccion: string = "";
    public _contrasenia: string = "";
    public _rol: string = "";
    public carroCompras: CarroCompras[] = [];
    public facturas: Factura[] = [];
    constructor(idUsuario:number,email:string, nombre:string, apellido:string,  
        direccion:string, contrasenia:string, rol:string){
            this._idUsuario = idUsuario;
            this._email = email;
            this._nombre = nombre;
            this._apellido = apellido;
            this._direccion = direccion;
            this._contrasenia = contrasenia;        
            this._rol = rol;
    }
}