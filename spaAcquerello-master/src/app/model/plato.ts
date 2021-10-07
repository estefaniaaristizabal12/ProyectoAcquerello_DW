export class Plato{
    public _nombre: string = "";
    public _descripcion: string = "";
    public _imagen: string = "";
    public _precio: number;
    constructor ( nombre:string, descripcion:string,  imagen:string,  precio:number){
        this._nombre = nombre;
        this._descripcion = descripcion;
        this._imagen = imagen;
        this._precio = precio;
    }  
}