/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;

import java.io.Serializable;

/**
 *
 * @author DaveHell
 */
public class DTO_Ingresos implements Serializable{
    
    
    private int idIngreso;    
    private DTO_Categoriaingresos catIngresos;
    private DTO_Controlfechas fechas;
    private long valor;
    private DTO_Usuario usuarioId;

    public DTO_Ingresos() {
    }

    public DTO_Ingresos(int idIngreso, DTO_Categoriaingresos catIngresos, DTO_Controlfechas fechas, long valor, DTO_Usuario usuarioId) {
        this.idIngreso = idIngreso;
        this.catIngresos = catIngresos;
        this.fechas = fechas;
        this.valor = valor;
        this.usuarioId = usuarioId;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public DTO_Categoriaingresos getCatIngresos() {
        return catIngresos;
    }

    public void setCatIngresos(DTO_Categoriaingresos catIngresos) {
        this.catIngresos = catIngresos;
    }

    public DTO_Controlfechas getFechas() {
        return fechas;
    }

    public void setFechas(DTO_Controlfechas fechas) {
        this.fechas = fechas;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public DTO_Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(DTO_Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
    
}
