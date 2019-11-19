/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DTO.DTO_Categoriaingresos;
import com.mycompany.DTO.DTO_Controlfechas;
import com.mycompany.DTO.DTO_Ingresos;
import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.consultas.IngresosConsultas;
import com.mycompany.interfaces.ICategoriaingresosFacade;
import com.mycompany.interfaces.IControlfechasFacade;
import com.mycompany.interfaces.IIngresosFacade;
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
@Named(value = "ingresosController")
@RequestScoped
public class ingresosController implements Serializable{
    
    private int selectCategoriaIngresos;
    private int selectIdFechas;
    private long valor;
    private List<DTO_Categoriaingresos> listaCategoraIngresos;
    private List<DTO_Controlfechas> listaControlFechas;

    public ingresosController(int selectCategoriaIngresos, int selectIdFechas, long valor) {
        this.selectCategoriaIngresos = selectCategoriaIngresos;
        this.selectIdFechas = selectIdFechas;
        this.valor = valor;
    }

    public int getSelectCategoriaIngresos() {
        return selectCategoriaIngresos;
    }

    public void setSelectCategoriaIngresos(int selectCategoriaIngresos) {
        this.selectCategoriaIngresos = selectCategoriaIngresos;
    }

    public int getSelectIdFechas() {
        return selectIdFechas;
    }

    public void setSelectIdFechas(int selectIdFechas) {
        this.selectIdFechas = selectIdFechas;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public List<DTO_Categoriaingresos> getListaCategoraIngresos() {
        return listaCategoraIngresos;
    }

    public void setListaCategoraIngresos(List<DTO_Categoriaingresos> listaCategoraIngresos) {
        this.listaCategoraIngresos = listaCategoraIngresos;
    }

    public List<DTO_Controlfechas> getListaControlFechas() {
        return listaControlFechas;
    }

    public void setListaControlFechas(List<DTO_Controlfechas> listaControlFechas) {
        this.listaControlFechas = listaControlFechas;
    }
    
    @EJB
    ICategoriaingresosFacade catIngresosInterface;
    
    @EJB
    IControlfechasFacade fechasInterface;
    
    private List<DTO_Ingresos> listaIngresos;

    public List<DTO_Ingresos> getListaIngresos() {
        return listaIngresos;
    }

    public void setListaIngresos(List<DTO_Ingresos> listaIngresos) {
        this.listaIngresos = listaIngresos;
    }
    
    @EJB
    IIngresosFacade ingresoInterface;
    
    @PostConstruct
    public void init(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        listaCategoraIngresos = catIngresosInterface.vermisIngresos(us.getIdUsuario());
        listaControlFechas = fechasInterface.vermisFechas(us.getIdUsuario());
        listaIngresos = ingresoInterface.vermisIngresos(us.getIdUsuario());
    }
    /**
     * Creates a new instance of ingresosController
     */
    public ingresosController() {
    }
    
    @EJB
    IngresosConsultas ingresoConsultas;
    
    public void crearIngreso(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        ingresoConsultas.crearIngreso(us.getIdUsuario(), selectIdFechas, selectCategoriaIngresos, valor);        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Datos Creados"));
    }
    
}
