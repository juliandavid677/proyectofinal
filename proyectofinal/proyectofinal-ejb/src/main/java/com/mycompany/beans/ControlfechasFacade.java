/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.DTO.DTO_Controlfechas;
import com.mycompany.interfaces.IControlfechasFacade;
import com.mycompany.entity.Controlfechas;
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
public class ControlfechasFacade extends AbstractFacade<Controlfechas> implements IControlfechasFacade {
    @PersistenceContext(unitName = "com.mycompany_proyectofinal-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ControlfechasFacade() {
        super(Controlfechas.class);
    }
    
    @Override
    public List<DTO_Controlfechas> vermisFechas(int id){
        List<DTO_Controlfechas> catFechas = null;
        TypedQuery<Controlfechas> typeCont;
        typeCont = em.createNamedQuery("consultaFEC", Controlfechas.class);  
        typeCont.setParameter("iduser", id);
        List<Controlfechas> catIngre = typeCont.getResultList();  
        if(!catIngre.isEmpty()){
            ModelMapper modelMapper = new ModelMapper();
            catFechas = modelMapper.map(catIngre, new TypeToken<List<DTO_Controlfechas>>(){}.getType());
        }        
        return catFechas;
    }
}
