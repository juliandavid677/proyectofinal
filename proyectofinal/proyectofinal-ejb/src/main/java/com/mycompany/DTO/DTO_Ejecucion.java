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
public class DTO_Ejecucion implements Serializable{    
    
    private int idEjecucion;
    private DTO_Egresos egresosE;
    private long valor;
    private DTO_Usuario idUsuario;

    public DTO_Ejecucion() {
    }

    public DTO_Ejecucion(int idEjecucion, DTO_Egresos egresosE, long valor, DTO_Usuario idUsuario) {
        this.idEjecucion = idEjecucion;
        this.egresosE = egresosE;
        this.valor = valor;
        this.idUsuario = idUsuario;
    }

    

    public int getIdEjecucion() {
        return idEjecucion;
    }

    public void setIdEjecucion(int idEjecucion) {
        this.idEjecucion = idEjecucion;
    }

    public DTO_Egresos getEgresosE() {
        return egresosE;
    }

    public void setEgresosE(DTO_Egresos egresosE) {
        this.egresosE = egresosE;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public DTO_Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(DTO_Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
