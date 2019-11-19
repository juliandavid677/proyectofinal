/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultas;

import com.mycompany.entity.Categoriaingresos;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.ICategoriaingresosFacade;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DaveHell
 */
@Stateless
public class CatingresosConsultas implements Serializable{
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    @EJB
    ICategoriaingresosFacade catIngInterface;
    
    public void crearCategoriaIngresos(String nomCat, String descCat,int id){
        
        Usuario user = usuarioInterface.find(id);
        if(user != null){
            Categoriaingresos catIngresos = new Categoriaingresos(nomCat, descCat, user);
            catIngInterface.create(catIngresos);
        }
    }
    
    public void editarCategoriaIngresos(int id, String nombreCat, String desCat){
        Categoriaingresos catIngre = catIngInterface.find(id);
        catIngre.setNombreCategoria(nombreCat);
        catIngre.setDescripcionCategoria(desCat);
        catIngInterface.edit(catIngre);
    }
    
    public void eliminarCategoriaIngresos(int id){
        
        Categoriaingresos catIngre = catIngInterface.find(id);
        catIngInterface.remove(catIngre);
        
    }
}
