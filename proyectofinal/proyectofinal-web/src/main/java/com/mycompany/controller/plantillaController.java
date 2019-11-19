/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.entity.Usuario;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author DaveHell
 */
@Named(value = "plantillaController")
@SessionScoped
public class plantillaController implements Serializable{

    /**
     * Creates a new instance of plantillaController
     */
    public plantillaController() {
    }
    
    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            DTO_Usuario us;
            us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");            
                        
            if(us == null){
                context.getExternalContext().redirect("../../error.xhtml");
            }
            
        } catch (Exception e) {
        }
    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
