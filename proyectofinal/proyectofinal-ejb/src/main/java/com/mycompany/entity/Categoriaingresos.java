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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author DaveHell
 */
@Entity
@Table(name = "categoriaingresos")
@NamedQueries({
    @NamedQuery(name = "consultaIG", query = "SELECT ci FROM Categoriaingresos ci WHERE ci.usuarioId.idUsuario = :iduser")
})
public class Categoriaingresos implements Serializable{
    @Id       
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   
    @Column(name = "id_categoriaingresos")
    private int idCategoriaingresos;
    
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuarioId;

    public Categoriaingresos() {
    }

    public Categoriaingresos(String nombreCategoria, String descripcionCategoria, Usuario usuarioId) {
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.usuarioId = usuarioId;
    }

    public int getIdCategoriaingresos() {
        return idCategoriaingresos;
    }

    public void setIdCategoriaingresos(int idCategoriaingresos) {
        this.idCategoriaingresos = idCategoriaingresos;
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
