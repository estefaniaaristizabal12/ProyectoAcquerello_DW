package com.desarrolloWeb.ProyectoAcquerello.modelo;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Entity;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Basic
    private String nombre;

    @Basic
    private String apellido;

    @Basic
    private String direccion;

    @Basic
    private String email;

    @Basic
    private String contrasenia;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuariof")
    private List<Factura> facturas;  //Un usuario tiene muchas facturas

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioc")
    private List<CarroCompras> carroCompras;  //Un usuario tiene muchos productos en un carro de compras 

    //Constructor
    public Usuario(){

    }

    //Getter
    public Long getIdUsuario(){
        return idUsuario;
    } 

    public String getNombre(){
        return nombre;
    } 

    public String getApellido(){
        return apellido;
    } 

    public String getDireccion(){
        return direccion;
    }

    public String getEmail(){
        return email;
    } 

    public String getContrasenia(){
        return contrasenia;
    } 

    //Setter

    public void setIdUsuario(Long idUsuario){
        this.idUsuario = idUsuario ;
    } 

    public void setNombre(String nombre){
        this.nombre = nombre ;
    } 

    public void setApellido (String apellido){
        this.apellido = apellido ;
    } 


    public void setDireccion(String direccion){
        this.direccion = direccion ;
    } 
   
    public void setEmail(String email){
        this.email = email ;
    } 

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia ;
    } 
    
}
