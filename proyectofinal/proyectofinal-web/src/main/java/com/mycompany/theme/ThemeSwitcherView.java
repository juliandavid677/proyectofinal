/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author DaveHell
 */
@Named(value = "themeSwitcherView")
@RequestScoped
public class ThemeSwitcherView implements Serializable {

    private List<Theme> themes;

    @PostConstruct
    public void init() {
        themes = new ArrayList<>();
        themes.add(new Theme(0, "Tema Claro", "start"));
        themes.add(new Theme(1, "Tema Oscuro", "luna-blue"));
        
    }

    public List<Theme> getThemes() {
        return themes;
    }
    
    
}
