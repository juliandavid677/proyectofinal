/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultas;

import com.mycompany.DTO.DTO_Categoria;
import com.mycompany.entity.Categoria;
import static com.mycompany.entity.Categoria_.idCategoria;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.ICategoriaFacade;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DaveHell
 */
@Stateless
public class CategoriaConsultas implements Serializable{
    
    @EJB
    ICategoriaFacade categoriaInterface;
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    public void crearCategoria(int a){
        
        Usuario user = usuarioInterface.find(a);
        if(user != null){
            Categoria categoria = new Categoria("micat", "midesc de cat", user);
        categoriaInterface.create(categoria);
        }
        
        
        
    }
}
