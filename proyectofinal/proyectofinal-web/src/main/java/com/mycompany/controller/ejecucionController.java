/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DTO.DTO_Egresos;
import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.consultas.EjecucionConsultas;
import com.mycompany.interfaces.IEgresosFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author DaveHell
 */
@Named(value = "ejecucionController")
@RequestScoped
public class ejecucionController implements Serializable{
    
    private int selectEgreso;
    private long valor;
    private List<DTO_Egresos> listaEgresos;

    public ejecucionController(int selectEgreso, long valor) {
        this.selectEgreso = selectEgreso;
        this.valor = valor;
    }

    public int getSelectEgreso() {
        return selectEgreso;
    }

    public void setSelectEgreso(int selectEgreso) {
        this.selectEgreso = selectEgreso;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public List<DTO_Egresos> getListaEgresos() {
        return listaEgresos;
    }

    public void setListaEgresos(List<DTO_Egresos> listaEgresos) {
        this.listaEgresos = listaEgresos;
    }
    
    @EJB
    IEgresosFacade egresosInterface;
    
    @PostConstruct
    public void init(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");        
        listaEgresos = egresosInterface.vermisEgresos(us.getIdUsuario());
        
    }
    
    /**
     * Creates a new instance of ejecucionController
     */
    public ejecucionController() {
    }
    
    @EJB
    EjecucionConsultas ejecucionConsultas;
    
    public void crearEjecucion(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        ejecucionConsultas.createEjecucion(selectEgreso, valor, us.getIdUsuario());
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Datos Creados"));
    }
}
