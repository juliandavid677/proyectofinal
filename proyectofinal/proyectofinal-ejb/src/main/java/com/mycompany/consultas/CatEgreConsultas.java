/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultas;

import com.mycompany.DTO.DTO_Categoriaegresos;
import com.mycompany.entity.Categoriaegresos;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.ICategoriaegresosFacade;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.lang.reflect.Type;
/**
 *
 * @author DaveHell
 */
@Stateless
public class CatEgreConsultas implements Serializable{
    
    @EJB
    ICategoriaegresosFacade egresosCatInterface;
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    public void crearCategoriaEgresos(String nomCat, String descCat,int id){
        
        Usuario user = usuarioInterface.find(id);
        if(user != null){
            Categoriaegresos categoriaegresos = new Categoriaegresos(nomCat, descCat, user);
            egresosCatInterface.create(categoriaegresos);
        }
    }
    
    public void editarCategoriaEgresos(int id, String nombreCat, String desCat){
        Categoriaegresos catEgre = egresosCatInterface.find(id);
        catEgre.setNombreCategoria(nombreCat);
        catEgre.setDescripcionCategoria(desCat);
        egresosCatInterface.edit(catEgre);
    }
    
    public void eliminarCategoriaEgresos(int id){
        
        Categoriaegresos catEgre = egresosCatInterface.find(id);
        egresosCatInterface.remove(catEgre);
        
    }
    
            
}
