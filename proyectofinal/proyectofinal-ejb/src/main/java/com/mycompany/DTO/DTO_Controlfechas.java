/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;

import java.util.Date;

/**
 *
 * @author DaveHell
 */
public class DTO_Controlfechas {
    
    
    private int idFechaPrimaria;
    private String nombreRango;
    private Date fechaInicio;
    private Date fechaFin;
    private DTO_Usuario usuarioId;

    public DTO_Controlfechas() {
    }

    public DTO_Controlfechas(int idFechaPrimaria, String nombreRango, Date fechaInicio, Date fechaFin, DTO_Usuario usuarioId) {
        this.idFechaPrimaria = idFechaPrimaria;
        this.nombreRango = nombreRango;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuarioId = usuarioId;
    }

    public int getIdFechaPrimaria() {
        return idFechaPrimaria;
    }

    public void setIdFechaPrimaria(int idFechaPrimaria) {
        this.idFechaPrimaria = idFechaPrimaria;
    }

    public String getNombreRango() {
        return nombreRango;
    }

    public void setNombreRango(String nombreRango) {
        this.nombreRango = nombreRango;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public DTO_Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(DTO_Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    
    
    
    
    
}
