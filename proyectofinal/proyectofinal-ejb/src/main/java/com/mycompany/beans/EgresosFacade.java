/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.DTO.DTO_Egresos;
import com.mycompany.interfaces.IEgresosFacade;
import com.mycompany.entity.Egresos;
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
public class EgresosFacade extends AbstractFacade<Egresos> implements IEgresosFacade {
    @PersistenceContext(unitName = "com.mycompany_proyectofinal-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EgresosFacade() {
        super(Egresos.class);
    }
    
    @Override
    public List<DTO_Egresos> vermisEgresos(int id){
        List<DTO_Egresos> Egresos = null;
        TypedQuery<Egresos> typeCont;
        typeCont = em.createNamedQuery("consultaEgre", Egresos.class);  
        typeCont.setParameter("iduser", id);
        List<Egresos> Egre = typeCont.getResultList();  
        if(!Egre.isEmpty()){
            ModelMapper modelMapper = new ModelMapper();
            Egresos = modelMapper.map(Egre, new TypeToken<List<DTO_Egresos>>(){}.getType());
        }        
        return Egresos;
    }
}
