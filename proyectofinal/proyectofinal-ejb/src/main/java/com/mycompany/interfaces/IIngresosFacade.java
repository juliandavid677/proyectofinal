/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.DTO.DTO_Ingresos;
import com.mycompany.entity.Ingresos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DaveHell
 */
@Local
public interface IIngresosFacade {

    void create(Ingresos ingresos);

    void edit(Ingresos ingresos);

    void remove(Ingresos ingresos);

    Ingresos find(Object id);

    List<Ingresos> findAll();

    List<Ingresos> findRange(int[] range);

    int count();
    
    List<DTO_Ingresos> vermisIngresos(int id);
    
}
