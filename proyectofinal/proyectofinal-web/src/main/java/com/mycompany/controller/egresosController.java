/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DTO.DTO_Categoriaegresos;
import com.mycompany.DTO.DTO_Controlfechas;
import com.mycompany.DTO.DTO_Egresos;
import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.consultas.EgresosConsultas;
import com.mycompany.interfaces.ICategoriaegresosFacade;
import com.mycompany.interfaces.IControlfechasFacade;
import com.mycompany.interfaces.IEgresosFacade;
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
@Named(value = "egresosController")
@RequestScoped
public class egresosController implements Serializable{

    private int selectCategoriaEgresos;
    private int selectIdFechas;
    private long valor;
    private List<DTO_Categoriaegresos> listaCategoraEgresos;
    private List<DTO_Controlfechas> listaControlFechas;

    public egresosController(int selectCategoriaEgresos, int selectIdFechas, long valor) {
        this.selectCategoriaEgresos = selectCategoriaEgresos;
        this.selectIdFechas = selectIdFechas;
        this.valor = valor;
    }

    public int getSelectCategoriaEgresos() {
        return selectCategoriaEgresos;
    }

    public void setSelectCategoriaEgresos(int selectCategoriaEgresos) {
        this.selectCategoriaEgresos = selectCategoriaEgresos;
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

    public List<DTO_Categoriaegresos> getListaCategoraEgresos() {
        return listaCategoraEgresos;
    }

    public void setListaCategoraEgresos(List<DTO_Categoriaegresos> listaCategoraEgresos) {
        this.listaCategoraEgresos = listaCategoraEgresos;
    }

    public List<DTO_Controlfechas> getListaControlFechas() {
        return listaControlFechas;
    }

    public void setListaControlFechas(List<DTO_Controlfechas> listaControlFechas) {
        this.listaControlFechas = listaControlFechas;
    }
    
    @EJB
    ICategoriaegresosFacade catEgreInterface;
    
    @EJB
    IControlfechasFacade fechasInterface;
    
    private List<DTO_Egresos> listaEgresos;

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
        listaCategoraEgresos = catEgreInterface.vermisEgresos(us.getIdUsuario());
        listaControlFechas = fechasInterface.vermisFechas(us.getIdUsuario());
        listaEgresos = egresosInterface.vermisEgresos(us.getIdUsuario());
    }
    
    public void verTabla(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        listaEgresos = egresosInterface.vermisEgresos(us.getIdUsuario());
    }
    
    /**
     * Creates a new instance of egresosController
     */
    public egresosController() {
    }
    
    @EJB
    EgresosConsultas egresosConsultas;
    
    public void crearEgreso(){
        DTO_Usuario us;
        FacesContext context = FacesContext.getCurrentInstance();
        us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
        egresosConsultas.crearEgreso(us.getIdUsuario(), selectIdFechas, selectCategoriaEgresos, valor);       
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Datos Creados"));
        verTabla();
    }
    
    public void onRowEdit(RowEditEvent event){
        DTO_Egresos controldto = (DTO_Egresos) event.getObject();
        egresosConsultas.editarEgreso(controldto.getIdEgreso(), controldto.getValor());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
        "Fecha Modificada"));
        verTabla();
    }
     
    public void onRowCancel() {
        verTabla();
    }
    
    public void onRowDelete(DTO_Egresos con){
        FacesContext context = FacesContext.getCurrentInstance();
        egresosConsultas.eliminarEgreso(con.getIdEgreso());
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Exito!",
        "Fecha Eliminada"));
        verTabla();
    }
            
    
}
