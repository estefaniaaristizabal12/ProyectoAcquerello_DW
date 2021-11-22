package com.desarrolloWeb.ProyectoAcquerello.dtos;

import java.util.List;

public class UsuarioDTO {
    

    private Long _idUsuario;
    private String _email;
    private String _nombre;
    private String _apellido;
    private String _direccion;
    private String _contrasenia;
    private String _rol;

    

    public String get_rol() {
        return _rol;
    }
    public void set_rol(String _rol) {
        this._rol = _rol;
    }
    public Long get_idUsuario() {
        return _idUsuario;
    }
    public void set_idUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    public String get_email() {
        return _email;
    }
    public void set_email(String _email) {
        this._email = _email;
    }
    public String get_nombre() {
        return _nombre;
    }
    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }
    public String get_apellido() {
        return _apellido;
    }
    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }
    public String get_direccion() {
        return _direccion;
    }
    public void set_direccion(String _direccion) {
        this._direccion = _direccion;
    }
    public String get_contrasenia() {
        return _contrasenia;
    }
    public void set_contrasenia(String _contrasenia) {
        this._contrasenia = _contrasenia;
    }    

}
