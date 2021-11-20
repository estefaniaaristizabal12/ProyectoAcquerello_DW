import { Usuario } from "./usuario";
import { Plato } from "./plato";
import { Factura } from "./factura";


export class CarroCompras {
    auxx: CarroCompras[] = [];
    auxxf: Factura [] = [];
    public _id_CC: number;
    public _nombreProducto: string = "";
    public usuarioC: Usuario = new Usuario(0,"","","","","","");
    public platoC: Plato = new Plato(0,'','','',0);
    public _foto: string = "";
    public _cantidad: number;
    public _precio: number;


    constructor(id_CC: number, nombre:string, cantidad:number,  precio:number,  foto:string){
            this._id_CC = id_CC;
            this._nombreProducto = nombre;
            this._cantidad = cantidad;
            this._precio = precio;   
            this._foto = foto;
    }
}