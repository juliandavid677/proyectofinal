/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.DTO.DTO_Categoriaingresos;
import com.mycompany.interfaces.ICategoriaingresosFacade;
import com.mycompany.entity.Categoriaingresos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

/**
 *
 * @author DaveHell
 */
@Stateless
public class CategoriaingresosFacade extends AbstractFacade<Categoriaingresos> implements ICategoriaingresosFacade {
    @PersistenceContext(unitName = "com.mycompany_proyectofinal-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaingresosFacade() {
        super(Categoriaingresos.class);
    }
    
    @Override
    public List<DTO_Categoriaingresos> vermisIngresos(int id){
        List<DTO_Categoriaingresos> catIng = null;
        TypedQuery<Categoriaingresos> typeCat;
        typeCat = em.createNamedQuery("consultaIG", Categoriaingresos.class);
        typeCat.setParameter("iduser", id);
        List<Categoriaingresos> catIngre = typeCat.getResultList();        
        if(!catIngre.isEmpty()){
            ModelMapper modelMapper = new ModelMapper();
            catIng = modelMapper.map(catIngre, new TypeToken<List<DTO_Categoriaingresos>>(){}.getType());
        }        
        return catIng;
    }
    
}
