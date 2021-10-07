package com.desarrolloWeb.ProyectoAcquerello.modelo;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;


@Entity
public class Factura {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @ManyToOne
    private Plato plato; //Muchas facturas tienen un plato

    @ManyToOne
    private Usuario usuario; //Muchas facturas tienen un usuario

   // @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fecha;

    @Basic
    private Integer cantidad;

    @Basic
    private float total;


    //Constructor
    public Factura(){

    }
    
    //Getter
    public Long getIdFactura(){
        return idFactura;
    } 

    public Plato getPlato(){
        return plato;
    } 

    public Usuario getUsuario(){
        return usuario;
    } 

    public Integer getCantidad(){
        return cantidad;
    }

    public float getTotal(){
        return total;
    } 

    public LocalDateTime getFecha(){
        return fecha;
    } 

    //Setter

    public void setIdFactura(Long idFactura){
        this.idFactura = idFactura ;
    } 

    public void setIdPlato(Plato plato){
        this.plato = plato ;
    } 

    public void setIdUsuario(Usuario usuario){
        this.usuario = usuario ;
    } 


    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad ;
    } 
   
    public void setTotal(float total){
        this.total = total ;
    } 
    
}
