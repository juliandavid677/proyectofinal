/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DTO.DTO_Controlfechas;
import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.consultas.FechasConsultas;
import com.mycompany.interfaces.IControlfechasFacade;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author DaveHell
 */
@Named(value = "fechasformController")
@RequestScoped
public class fechasformController implements Serializable{

    /**
     * Creates a new instance of fechasformController
     */
    
    private Date fechaInicio;
    private Date fechaFin;
    
    

    public fechasformController(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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

    

    private String periodo;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public fechasformController(Date fechaInicio, Date fechaFin, String periodo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.periodo = periodo;
    }
    
    

    
    
    

    public fechasformController() {
    }
    
    @EJB
    FechasConsultas consultafechas;
    
    public void crearFecha(){
        
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        consultafechas.crearFecha(periodo, fechaInicio, fechaFin, us.getIdUsuario());
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Fecha Creada"));
        this.periodo = null;
        this.fechaInicio = null;
        this.fechaFin = null;
        verTabla();
    }
    
    @EJB
    IControlfechasFacade fechasInterface;        
      
    List<DTO_Controlfechas> listaFechas;

    public List<DTO_Controlfechas> getListaFechas() {
        return listaFechas;
    }

    public void setListaFechas(List<DTO_Controlfechas> listaFechas) {
        this.listaFechas = listaFechas;
    }
    
    @PostConstruct
    public void verTabla(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        listaFechas = fechasInterface.vermisFechas(us.getIdUsuario());        
    }
    
    public void onRowEdit(RowEditEvent event){
        DTO_Controlfechas controldto = (DTO_Controlfechas) event.getObject();
        consultafechas.editarFecha(controldto.getIdFechaPrimaria(), controldto.getNombreRango(), controldto.getFechaInicio(), controldto.getFechaFin());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Fecha Modificada"));
        verTabla();
    }
     
    public void onRowCancel() {
        verTabla();
    }
    
    public void onRowDelete(DTO_Controlfechas con){
        consultafechas.eliminarFecha(con.getIdFechaPrimaria());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Exito!",
        "Fecha Eliminada"));
        verTabla();
    }
    
}
