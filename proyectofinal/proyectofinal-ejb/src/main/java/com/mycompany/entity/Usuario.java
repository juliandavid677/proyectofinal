/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DaveHell
 */
@Entity
@Table(name="usuario")
@NamedQueries({
    @NamedQuery(name = "consulta", query = "SELECT u FROM Usuario u  WHERE u.correo = :correo AND u.clave = :clave"),
    @NamedQuery(name = "correoigual", query = "SELECT u FROM Usuario u  WHERE u.correo = :correo "),
    @NamedQuery(name = "claveigual", query = "SELECT u FROM Usuario u  WHERE u.clave = :clave ")
})

public class Usuario implements Serializable{
    
    @Id       
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   
    @Column(name = "id_usuario")
    private int idUsuario;
    
    @Column
    private String nombre;
    
    @Column
    private String correo;
    
    @Column
    private String clave;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String clave) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
