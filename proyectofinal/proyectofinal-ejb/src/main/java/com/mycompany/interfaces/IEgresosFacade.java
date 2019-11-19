/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.DTO.DTO_Egresos;
import com.mycompany.entity.Egresos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DaveHell
 */
@Local
public interface IEgresosFacade {

    void create(Egresos egresos);

    void edit(Egresos egresos);

    void remove(Egresos egresos);

    Egresos find(Object id);

    List<Egresos> findAll();

    List<Egresos> findRange(int[] range);

    int count();
    
    List<DTO_Egresos> vermisEgresos(int id);
}
