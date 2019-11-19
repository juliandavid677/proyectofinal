/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.consultas.UsuarioConsultas;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import javax.faces.context.FacesContext;

/**
 *
 * @author DaveHell
 */
@Named(value = "cambiopassController")
@RequestScoped
public class cambiopassController implements Serializable{

    /**
     * Creates a new instance of cambiopassController
     */
    public cambiopassController() {
    }
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    @EJB
    UsuarioConsultas usuarioCon;
    
    private String passActual;
    private String passNueva;
    private String passConfirma;

    public cambiopassController(String passActual, String passNueva, String passConfirma) {
        this.passActual = passActual;
        this.passNueva = passNueva;
        this.passConfirma = passConfirma;
    }

    public String getPassActual() {
        return passActual;
    }

    public void setPassActual(String passActual) {
        this.passActual = passActual;
    }

    public String getPassNueva() {
        return passNueva;
    }

    public void setPassNueva(String passNueva) {
        this.passNueva = passNueva;
    }

    public String getPassConfirma() {
        return passConfirma;
    }

    public void setPassConfirma(String passConfirma) {
        this.passConfirma = passConfirma;
    }
    
    public void cambiarPass() throws NoSuchAlgorithmException{
        
        String conActual = contraseña(passActual);
        String conNueva = contraseña(passNueva);
        DTO_Usuario user;
        user = usuarioInterface.claveIgual(conActual);
        if(user != null){
            if(passNueva == null ? passConfirma == null : passNueva.equals(passConfirma)){
                FacesContext context = FacesContext.getCurrentInstance();
                DTO_Usuario us;
                us = (DTO_Usuario) context.getExternalContext().getSessionMap().get("usuario");
                System.out.println("este es un nuevo id" + us.getIdUsuario());
                usuarioCon.cambioPass(us.getIdUsuario(), conNueva);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
                        "Contraseña Modificada"));
            }
            else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
                        "Las contraseñas son diferentes"));
            }
            
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", 
            "Datos Incorrectos" ));
        }        
        
    }
    
    public String contraseña(String password) throws NoSuchAlgorithmException{
    
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashText = number.toString(16);
            while(hashText.length()<32){
                hashText = "0"+hashText;
            }
            
            String cifPass = hashText;
            return cifPass;
    }
    
}
