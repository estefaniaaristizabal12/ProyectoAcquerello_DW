import { CarroCompras } from "./carroCompras";

export class Usuario {
    public _email: string = "";
    public _nombre: string = "";
    public _apellido: string = "";
    public _direccion: string = "";
    public _contrasenia: string = "";
    public _rol: string = "";
    public listaCC: CarroCompras[] = [];
    public ordenes: CarroCompras[] = [];
    constructor(nombre:string, apellido:string,  email:string, 
         contrasenia:string,  direccion:string,  rol:string){
            this._email = email;
            this._nombre = nombre;
            this._apellido = apellido;
            this._direccion = direccion;
            this._contrasenia = contrasenia;        
            this._rol = rol;
    }
}