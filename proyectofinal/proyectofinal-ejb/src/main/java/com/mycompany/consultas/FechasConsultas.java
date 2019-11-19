/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultas;

import com.mycompany.entity.Controlfechas;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.IControlfechasFacade;
import com.mycompany.interfaces.IUsuarioFacade;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DaveHell
 */
@Stateless
public class FechasConsultas {
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    @EJB
    IControlfechasFacade fechaInterface;
    
    public void crearFecha(String nomFecha, Date iniFecha, Date finFecha,int id){
        
        Usuario user = usuarioInterface.find(id);
        if(user != null){
            Controlfechas control = new Controlfechas(nomFecha, iniFecha, finFecha, user);
            fechaInterface.create(control);
        }
    }
    
    public void editarFecha(int id,String nomFecha, Date iniFecha, Date finFecha){
        
        Controlfechas fechacon = fechaInterface.find(id);
        fechacon.setNombreRango(nomFecha);
        fechacon.setFechaInicio(iniFecha);
        fechacon.setFechaFin(finFecha);
        fechaInterface.edit(fechacon);
    }
    
    public void eliminarFecha(int id){
        Controlfechas fechacon = fechaInterface.find(id);
        fechaInterface.remove(fechacon);
    }
    
    
}
