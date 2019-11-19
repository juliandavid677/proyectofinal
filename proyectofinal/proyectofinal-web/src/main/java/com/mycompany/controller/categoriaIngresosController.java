/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;


import com.mycompany.DTO.DTO_Categoriaingresos;
import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.consultas.CatingresosConsultas;
import com.mycompany.interfaces.ICategoriaingresosFacade;
import java.io.Serializable;
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
@Named(value = "categoriaIngresosController")
@RequestScoped
public class categoriaIngresosController implements Serializable{

    private String nombreCategoria;
    private String descripcionCategoria;

    public categoriaIngresosController(String nombreCategoria, String descripcionCategoria) {
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
    
    @EJB
    ICategoriaingresosFacade ingresosInterface;
    
    @EJB
    CatingresosConsultas catIngCon;
    /**
     * Creates a new instance of categoriaIngresosController
     */
    public categoriaIngresosController() {
    }
    
    public void crearCategoriaIngreso(){
        
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        catIngCon.crearCategoriaIngresos(nombreCategoria, nombreCategoria, us.getIdUsuario());
                
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Categoria Creada"));
        verTabla();
    }
    
    private List<DTO_Categoriaingresos> listaIngresoscat;

    public List<DTO_Categoriaingresos> getListaIngresoscat() {
        return listaIngresoscat;
    }

    public void setListaIngresoscat(List<DTO_Categoriaingresos> listaIngresoscat) {
        this.listaIngresoscat = listaIngresoscat;
    }
    
    @PostConstruct
    public void verTabla(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        listaIngresoscat = ingresosInterface.vermisIngresos(us.getIdUsuario());
    }
    
    public void onRowEdit(RowEditEvent event){
        DTO_Categoriaingresos cat = (DTO_Categoriaingresos) event.getObject();
        catIngCon.editarCategoriaIngresos(cat.getIdCategoriaingresos(), cat.getNombreCategoria(), cat.getDescripcionCategoria());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Categoria Modificada"));
        verTabla();
    }
     
    public void onRowCancel() {
        verTabla();
    }
    
    public void onRowDelete(DTO_Categoriaingresos cat){
        catIngCon.eliminarCategoriaIngresos(cat.getIdCategoriaingresos());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Exito!",
        "Categoria Eliminada"));
        verTabla();
    }
    
}
