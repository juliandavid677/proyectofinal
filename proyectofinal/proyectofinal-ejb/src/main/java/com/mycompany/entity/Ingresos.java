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
@Table(name="ingresos")
@NamedQueries({
    @NamedQuery(name = "consultaIng", query = "SELECT i FROM Ingresos i WHERE i.usuarioId.idUsuario =  :iduser")
})
public class Ingresos implements Serializable{
    
    @Id       
    @GeneratedValue(strategy = GenerationType.SEQUENCE)   
    @Column(name = "id_ingreso")
    private int idIngreso;
    
    @ManyToOne
    @JoinColumn(name = "id_categoriaingreso",nullable = false)
    private Categoriaingresos catIngresos;
    
    @ManyToOne
    @JoinColumn(name = "id_fecha",nullable = false)
    private Controlfechas fechas;
    
    @Column(name = "valor")
    private long valor;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
    private Usuario usuarioId;

    public Ingresos() {
    }

    public Ingresos(Categoriaingresos catIngresos, Controlfechas fechas, long valor, Usuario usuarioId) {
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

    public Categoriaingresos getCatIngresos() {
        return catIngresos;
    }

    public void setCatIngresos(Categoriaingresos catIngresos) {
        this.catIngresos = catIngresos;
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
