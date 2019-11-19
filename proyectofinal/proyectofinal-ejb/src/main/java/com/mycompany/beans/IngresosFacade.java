/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.DTO.DTO_Ingresos;
import com.mycompany.interfaces.IIngresosFacade;
import com.mycompany.entity.Ingresos;
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
public class IngresosFacade extends AbstractFacade<Ingresos> implements IIngresosFacade {
    @PersistenceContext(unitName = "com.mycompany_proyectofinal-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresosFacade() {
        super(Ingresos.class);
    }
    
    @Override
    public List<DTO_Ingresos> vermisIngresos(int id){
        List<DTO_Ingresos> Ingresos = null;
        TypedQuery<Ingresos> typeCont;
        typeCont = em.createNamedQuery("consultaIng", Ingresos.class);  
        typeCont.setParameter("iduser", id);
        List<Ingresos> Ingre = typeCont.getResultList();  
        if(!Ingre.isEmpty()){
            ModelMapper modelMapper = new ModelMapper();
            Ingresos = modelMapper.map(Ingre, new TypeToken<List<DTO_Ingresos>>(){}.getType());
        }        
        return Ingresos;
    }
}
