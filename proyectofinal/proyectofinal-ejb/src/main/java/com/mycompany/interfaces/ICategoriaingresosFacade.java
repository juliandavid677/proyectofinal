/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.DTO.DTO_Categoriaingresos;
import com.mycompany.entity.Categoriaingresos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DaveHell
 */
@Local
public interface ICategoriaingresosFacade {

    void create(Categoriaingresos categoriaingresos);

    void edit(Categoriaingresos categoriaingresos);

    void remove(Categoriaingresos categoriaingresos);

    Categoriaingresos find(Object id);

    List<Categoriaingresos> findAll();

    List<Categoriaingresos> findRange(int[] range);

    int count();
    
    List<DTO_Categoriaingresos> vermisIngresos(int id);
}
