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
@Table(name = "categoriaegresos")
@NamedQueries({
    @NamedQuery(name = "consultaEG", query = "SELECT ce FROM Categoriaegresos ce WHERE ce.usuarioId.idUsuario = :iduser")
})
public class Categoriaegresos implements Serializable{
    
    @Id       
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   
    @Column(name = "id_categoriaegresos")
    private int idCategoriaegresos;
    
    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    
    @Column(name = "descripcion_categoria")
    private String descripcionCategoria;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuarioId;

    public Categoriaegresos() {
    }

    public Categoriaegresos(String nombreCategoria, String descripcionCategoria, Usuario usuarioId) {
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.usuarioId = usuarioId;
    }

    public int getIdCategoriaegresos() {
        return idCategoriaegresos;
    }

    public void setIdCategoriaegresos(int idCategoriaegresos) {
        this.idCategoriaegresos = idCategoriaegresos;
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
