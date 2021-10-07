export class CarroCompras {
    public _nombreProducto: string = "";
    public _foto: string = "";
    public _cantidad: number;
    public _precio: number;

    constructor( nombre:string, cantidad:number,  precio:number,  foto:string){
            this._nombreProducto = nombre;
            this._cantidad = cantidad;
            this._precio = precio;   
            this._foto = foto;
    }
}