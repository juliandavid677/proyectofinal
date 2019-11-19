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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DaveHell
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
    
    @Id       
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   
    @Column(name = "id_categoria")
    private int idCategoria;
    
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria; 
    
    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuarioId;

    public Categoria() {
    }

    public Categoria(String nombreCategoria, String descripcionCategoria, Usuario usuarioId) {
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.usuarioId = usuarioId;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    

    
    
    
    
    
    
}
