
export class Contactanos {
    public _email: string = "";
    public _nombre: string = "";
    public _apellido: string = "";
    public _descripcion: string = "";

    constructor(nombre:string, apellido:string,  email:string, 
           descripcion: string){
            this._email = email;
            this._nombre = nombre;
            this._apellido = apellido;
            this._descripcion = descripcion;        
    }
}