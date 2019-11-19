/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DaveHell
 */
@Local
public interface IUsuarioFacade {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    DTO_Usuario iniciarSesion(String correo, String clave);
    
    DTO_Usuario validaCorreo(String correo);
    
    DTO_Usuario claveIgual(String clave);
 
    
}
