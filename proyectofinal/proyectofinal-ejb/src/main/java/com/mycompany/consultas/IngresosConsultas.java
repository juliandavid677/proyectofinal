/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultas;

import com.mycompany.entity.Categoriaingresos;
import com.mycompany.entity.Controlfechas;
import com.mycompany.entity.Ingresos;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.ICategoriaingresosFacade;
import com.mycompany.interfaces.IControlfechasFacade;
import com.mycompany.interfaces.IIngresosFacade;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DaveHell
 */
@Stateless
public class IngresosConsultas implements Serializable{
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    @EJB
    IControlfechasFacade fechasInterface;
    
    @EJB
    ICategoriaingresosFacade catIngreInterface;
    
    @EJB
    IIngresosFacade ingresosIterface;
    
    public void crearIngreso(int iduser, int idfecha, int idcatingre, long valor){
        
        Usuario user = usuarioInterface.find(iduser);
        Controlfechas fechas = fechasInterface.find(idfecha);
        Categoriaingresos catingresos = catIngreInterface.find(idcatingre);
        if(user != null){
            Ingresos ingreso = new Ingresos(catingresos, fechas, valor, user);
            ingresosIterface.create(ingreso);
        }
    }
    
    public void editarIngreso(int idingreso, long valor){
        Ingresos ingreso = ingresosIterface.find(idingreso);
        ingreso.setValor(valor);
        ingresosIterface.edit(ingreso);
    }
    
    public void eliminarIngreso(int idingreso){
        Ingresos ingreso = ingresosIterface.find(idingreso);
        ingresosIterface.remove(ingreso);
    }
}
