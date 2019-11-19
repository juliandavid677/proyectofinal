/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entity.Ejecucion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DaveHell
 */
@Local
public interface IEjecucionFacade {

    void create(Ejecucion ejecucion);

    void edit(Ejecucion ejecucion);

    void remove(Ejecucion ejecucion);

    Ejecucion find(Object id);

    List<Ejecucion> findAll();

    List<Ejecucion> findRange(int[] range);

    int count();
    
}
