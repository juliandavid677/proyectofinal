/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.consultas.UsuarioConsultas;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author DaveHell
 */
@Named(value = "indexController")
@RequestScoped
public class indexController implements Serializable{

    @EJB
    private UsuarioConsultas usuarioCon;
    
    private String nombre;
    private String correo;
    private String clave;

    public indexController(String nombre, String correo, String clave) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    /**
     * Creates a new instance of indexController
     */
    public indexController() {
    }
    
    public void crearUsuario() throws NoSuchAlgorithmException{        
        
        String contrasena = contraseña(clave);        
        DTO_Usuario usuario = new DTO_Usuario(nombre, correo, contrasena);        
        usuarioCon.crearUsuario(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", 
            "Usuario Creado" ));
    }
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    public String iniciarSesion() throws NoSuchAlgorithmException{       
        String redireccion = null;
        DTO_Usuario us;        
        String contrasena = contraseña(clave);
        us = usuarioInterface.iniciarSesion(correo, contrasena);        
            if(us != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                redireccion = "/protegido/principal?faces-redirect=true";
            }
            else{
                FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", 
            "Datos Incorrectos" ));
            }
       
        return redireccion;
    }
    
    /**
     *
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String contraseña(String password) throws NoSuchAlgorithmException{
    
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashText = number.toString(16);
            while(hashText.length()<32){
                hashText = "0"+hashText;
            }
            System.out.println("esta es la clave: " + hashText);
            String cifPass = hashText;
            return cifPass;
    }
}
