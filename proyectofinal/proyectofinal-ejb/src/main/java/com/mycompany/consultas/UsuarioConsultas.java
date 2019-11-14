/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consultas;

import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.entity.Usuario;
import com.mycompany.interfaces.IUsuarioFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author DaveHell
 */
@Stateless
public class UsuarioConsultas implements Serializable{
    
    @EJB
    IUsuarioFacade usuarioInterface;
    
    public void crearUsuario(DTO_Usuario usuarioDto){
        Usuario usuario = new Usuario(usuarioDto.getNombre(), usuarioDto.getCorreo(), usuarioDto.getClave());
        usuarioInterface.create(usuario);
        
    }
}
