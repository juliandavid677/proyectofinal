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
public class DTO_Egresos implements Serializable{
    
    
    private int idEgreso;
    private DTO_Categoriaegresos categoriaEgresos;
    private DTO_Controlfechas fechas;
    private long valor;
    private DTO_Usuario usuarioId;

    public DTO_Egresos() {
    }

    public DTO_Egresos(int idEgreso, DTO_Categoriaegresos categoriaEgresos, DTO_Controlfechas fechas, long valor, DTO_Usuario usuarioId) {
        this.idEgreso = idEgreso;
        this.categoriaEgresos = categoriaEgresos;
        this.fechas = fechas;
        this.valor = valor;
        this.usuarioId = usuarioId;
    }

    public int getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(int idEgreso) {
        this.idEgreso = idEgreso;
    }

    public DTO_Categoriaegresos getCategoriaEgresos() {
        return categoriaEgresos;
    }

    public void setCategoriaEgresos(DTO_Categoriaegresos categoriaEgresos) {
        this.categoriaEgresos = categoriaEgresos;
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
