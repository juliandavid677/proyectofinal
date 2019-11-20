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
@Table(name="ejecucion")
public class Ejecucion implements Serializable{
    
    @Id       
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   
    @Column(name = "id_ejecucion")
    private int idEjecucion;
    
    @ManyToOne
    @JoinColumn(name = "id_egreso",nullable = false)
    private Egresos egresosE;
    
    @Column(name = "valor")
    private long valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario idUsuario;
    
    public Ejecucion() {
    }

    public Ejecucion(Egresos egresosE, long valor, Usuario idUsuario) {
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

    public Egresos getEgresosE() {
        return egresosE;
    }

    public void setEgresosE(Egresos egresosE) {
        this.egresosE = egresosE;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
}
