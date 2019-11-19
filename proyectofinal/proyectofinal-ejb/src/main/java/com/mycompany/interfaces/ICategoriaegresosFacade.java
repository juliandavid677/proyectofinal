/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.DTO.DTO_Categoriaegresos;
import com.mycompany.entity.Categoriaegresos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DaveHell
 */
@Local
public interface ICategoriaegresosFacade {

    void create(Categoriaegresos categoriaegresos);

    void edit(Categoriaegresos categoriaegresos);

    void remove(Categoriaegresos categoriaegresos);

    Categoriaegresos find(Object id);

    List<Categoriaegresos> findAll();

    List<Categoriaegresos> findRange(int[] range);

    int count();
    
    
    List<DTO_Categoriaegresos> vermisEgresos(int id);
    
}
