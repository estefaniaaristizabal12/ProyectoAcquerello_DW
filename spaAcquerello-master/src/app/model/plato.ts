export class Plato{
    public _idPlato: number;
    public _nombre: string = "";
    public _descripcion: string = "";
    public _imagen: string = "";
    public _precio: number;
    constructor (idPlato: number, nombre:string, descripcion:string,  imagen:string,  precio:number){
        this._idPlato =  idPlato;
        this._nombre = nombre;
        this._descripcion = descripcion;
        this._imagen = imagen;
        this._precio = precio;
    }  
}