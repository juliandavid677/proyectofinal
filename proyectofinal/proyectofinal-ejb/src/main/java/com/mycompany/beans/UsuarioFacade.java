/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;


import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.interfaces.IUsuarioFacade;
import com.mycompany.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author DaveHell
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements IUsuarioFacade {
    @PersistenceContext(unitName = "com.mycompany_proyectofinal-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    /**
     *
     * @param correo
     * @param clave
     * @return
     */
    @Override
    public DTO_Usuario iniciarSesion(String correo, String clave){        
        DTO_Usuario usuarioDto = null;
        Usuario usuario = null;
        try {
            TypedQuery<Usuario> consulta = em.createNamedQuery("consulta", Usuario.class);
            consulta.setParameter("correo", correo);
            consulta.setParameter("clave", clave);
            List<Usuario> listUsuario = consulta.getResultList();
            if(!listUsuario.isEmpty()){
                usuario = listUsuario.get(0);
                usuarioDto = new DTO_Usuario(usuario.getNombre(), usuario.getCorreo(), usuario.getClave());
            }
        } catch (Exception e) {
            throw e;
        }
        
        return usuarioDto;
         
    }
    
}
