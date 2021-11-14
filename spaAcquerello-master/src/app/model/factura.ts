import { Usuario } from "./usuario";
import { Plato } from "./plato";


export class Factura {
    public idFactura: number;
    public usuariof: Usuario = new Usuario(0,"","","","","");
    public platof: Plato = new Plato(0,'','','',0);
    public cantidad: number;
    public total: number;
    public fecha: Date = new Date();

    constructor(idFactura: number, cantidad:number,  total:number, fecha: Date){
        this.idFactura = idFactura;
        this.cantidad = cantidad;
        this.total = total;   
        this.fecha = fecha;
    }
}