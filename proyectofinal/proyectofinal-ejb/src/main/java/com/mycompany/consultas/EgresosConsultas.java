/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultas;

import com.mycompany.entity.Categoriaegresos;
import com.mycompany.entity.Controlfechas;
import com.mycompany.entity.Egresos;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.ICategoriaegresosFacade;
import com.mycompany.interfaces.IControlfechasFacade;
import com.mycompany.interfaces.IEgresosFacade;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DaveHell
 */
@Stateless
public class EgresosConsultas implements Serializable{
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    @EJB
    IControlfechasFacade fechasInterface;
    
    @EJB
    ICategoriaegresosFacade catEgreInterface;
    
    @EJB
    IEgresosFacade egresosIterface;
    
    public void crearEgreso(int iduser, int idfecha, int idcategre, long valor){
        
        Usuario user = usuarioInterface.find(iduser);
        Controlfechas fechas = fechasInterface.find(idfecha);
        Categoriaegresos categresos = catEgreInterface.find(idcategre);
        if(user != null){
            Egresos egreso = new Egresos(categresos, fechas, valor, user);
            egresosIterface.create(egreso);
        }
    }
    
    public void editarEgreso(int idegreso, long valor){
        Egresos egresos = egresosIterface.find(idegreso);
        egresos.setValor(valor);
        egresosIterface.edit(egresos);
    }
    
    public void eliminarEgreso(int idegreso){
        Egresos egresos = egresosIterface.find(idegreso);
        egresosIterface.remove(egresos);
    }
    
}
