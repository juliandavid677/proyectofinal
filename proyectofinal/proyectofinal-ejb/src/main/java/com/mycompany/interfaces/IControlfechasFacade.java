/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.DTO.DTO_Controlfechas;
import com.mycompany.entity.Controlfechas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DaveHell
 */
@Local
public interface IControlfechasFacade {

    void create(Controlfechas controlfechas);

    void edit(Controlfechas controlfechas);

    void remove(Controlfechas controlfechas);

    Controlfechas find(Object id);

    List<Controlfechas> findAll();

    List<Controlfechas> findRange(int[] range);

    int count();
    
    List<DTO_Controlfechas> vermisFechas(int id);
    
}
