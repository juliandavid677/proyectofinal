/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DTO.DTO_Categoriaegresos;
import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.consultas.CatEgreConsultas;
import com.mycompany.interfaces.ICategoriaegresosFacade;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named(value = "categoriaegresosController")
@RequestScoped
public class categoriaegresosController implements Serializable{

    private String nombreCategoria;
    private String descripcionCategoria;

    public categoriaegresosController(String nombreCategoria, String descripcionCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
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
    
    
    /**
     * Creates a new instance of categoriaegresosController
     */
    public categoriaegresosController() {
        listaEgresos = new ArrayList<>();
    }
    
    @EJB
    CatEgreConsultas categreConsultas;
    
    @EJB
    ICategoriaegresosFacade catInterface;
    
    
    
    public void crearCategoria(){
        verTabla();
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        categreConsultas.crearCategoriaEgresos(nombreCategoria, descripcionCategoria, us.getIdUsuario());                
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Categoria Creada"));
        this.nombreCategoria = null;
        this.descripcionCategoria = null;
        verTabla();
    }
    
    private List<DTO_Categoriaegresos> listaEgresos;

    public List<DTO_Categoriaegresos> getListaEgresos() {
        return listaEgresos;
    }

    public void setListaEgresos(List<DTO_Categoriaegresos> listaEgresos) {
        this.listaEgresos = listaEgresos;
    }
    
    @PostConstruct
    public void verTabla(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        listaEgresos = catInterface.vermisEgresos(us.getIdUsuario());
        
    }
    
    
    public void onRowEdit(RowEditEvent event){
        DTO_Categoriaegresos cat = (DTO_Categoriaegresos) event.getObject();        
        categreConsultas.editarCategoriaEgresos(cat.getIdCategoriaegresos(), cat.getNombreCategoria(), cat.getDescripcionCategoria());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Categoria Modificada"));
        verTabla();
    }
     
    public void onRowCancel() {
        verTabla();
    }
    
    public void onRowDelete(DTO_Categoriaegresos cat){
        
        categreConsultas.eliminarCategoriaEgresos(cat.getIdCategoriaegresos());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Exito!",
        "Categoria Eliminada"));
        verTabla();
    }
    
    
    
    
    
    
}
