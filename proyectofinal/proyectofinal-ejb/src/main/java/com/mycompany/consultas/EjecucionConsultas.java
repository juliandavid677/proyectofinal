/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultas;

import com.mycompany.entity.Egresos;
import com.mycompany.entity.Ejecucion;
import com.mycompany.interfaces.IEgresosFacade;
import com.mycompany.interfaces.IEjecucionFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DaveHell
 */
@Stateless
public class EjecucionConsultas implements Serializable{
    
    @EJB
    IEgresosFacade egresoInterface;
    
    @EJB
    IEjecucionFacade ejecucionInterface;
    
    public void createEjecucion(int idegreso, long valor){
        
       Egresos egreso = egresoInterface.find(idegreso);
       if(egreso != null){
           Ejecucion ejecucion = new Ejecucion(egreso, valor);
           ejecucionInterface.create(ejecucion);
       }
    }
    
    public void editarEjecucion(int idejecucion, long valor){
        Ejecucion ejecucion = ejecucionInterface.find(idejecucion);
        ejecucion.setValor(valor);
        ejecucionInterface.edit(ejecucion);
    }
    
    public void eliminarEjecucion(int idejecucion){
        Ejecucion ejecucion = ejecucionInterface.find(idejecucion);
        ejecucionInterface.remove(ejecucion);
    }
    
}
