/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.DTO.DTO_Categoriaegresos;
import com.mycompany.DTO.DTO_Usuario;
import com.mycompany.interfaces.ICategoriaegresosFacade;
import com.mycompany.entity.Categoriaegresos;
import com.mycompany.entity.Usuario;
import com.sun.media.sound.ModelMappedInstrument;
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
public class CategoriaegresosFacade extends AbstractFacade<Categoriaegresos> implements ICategoriaegresosFacade {
    @PersistenceContext(unitName = "com.mycompany_proyectofinal-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaegresosFacade() {
        super(Categoriaegresos.class);
    }
    
    @Override    
    public List<DTO_Categoriaegresos> vermisEgresos(int id){
        List<DTO_Categoriaegresos> catEnt = null;
        TypedQuery<Categoriaegresos> typeCat;
        typeCat = em.createNamedQuery("consultaEG", Categoriaegresos.class);
        typeCat.setParameter("iduser", id);
        List<Categoriaegresos> catEgre = typeCat.getResultList();        
        if(!catEgre.isEmpty()){
            ModelMapper modelMapper = new ModelMapper();
            catEnt = modelMapper.map(catEgre, new TypeToken<List<DTO_Categoriaegresos>>(){}.getType());
        }        
        return catEnt;
    }
    
}
