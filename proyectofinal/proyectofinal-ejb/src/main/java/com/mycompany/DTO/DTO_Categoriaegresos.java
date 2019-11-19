/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;



/**
 *
 * @author DaveHell
 */
public class DTO_Categoriaegresos {
    
    
    private int idCategoriaegresos;   
    
    private String nombreCategoria;    
    
    private String descripcionCategoria;    
    
    private DTO_Usuario usuarioId;

    public DTO_Categoriaegresos() {
    }

    public DTO_Categoriaegresos(int idCategoriaegresos, String nombreCategoria, String descripcionCategoria, DTO_Usuario usuarioId) {
        this.idCategoriaegresos = idCategoriaegresos;
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

    public DTO_Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(DTO_Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
    
}
