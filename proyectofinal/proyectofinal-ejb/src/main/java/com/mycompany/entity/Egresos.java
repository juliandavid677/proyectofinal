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
@Table(name="egresos")
@NamedQueries({
    @NamedQuery(name = "consultaEgre", query = "SELECT e FROM Egresos e WHERE e.usuarioId.idUsuario = :iduser")
})
public class Egresos implements Serializable{
    
    @Id       
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   
    @Column(name = "id_egreso")
    private int idEgreso;
    
    @ManyToOne
    @JoinColumn(name = "id_categoriaegresos",nullable = false)
    private Categoriaegresos categoriaEgresos;
    
    @ManyToOne
    @JoinColumn(name = "id_fecha",nullable = false)
    private Controlfechas fechas;
    
    @Column(name = "valor")
    private long valor;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuarioId;

    public Egresos() {
    }

    public Egresos(Categoriaegresos categoriaEgresos, Controlfechas fechas, long valor, Usuario usuarioId) {
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

    public Categoriaegresos getCategoriaEgresos() {
        return categoriaEgresos;
    }

    public void setCategoriaEgresos(Categoriaegresos categoriaEgresos) {
        this.categoriaEgresos = categoriaEgresos;
    }

    public Controlfechas getFechas() {
        return fechas;
    }

    public void setFechas(Controlfechas fechas) {
        this.fechas = fechas;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    
    
    
}
