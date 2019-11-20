/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theme;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author DaveHell
 */

@Named(value = "usuarioBean")
@SessionScoped
public class usuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String localidad;
    private static final Map<String, Object> lstPaises;

    static {
        lstPaises = new LinkedHashMap<>();
        Locale espanol = new Locale("es");
        lstPaises.put("Español", espanol);
        lstPaises.put("English", Locale.ENGLISH);
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Map<String, Object> getLstPaises() {
        return lstPaises;
    }

    public void localidadChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();
        for (Map.Entry<String, Object> entry : lstPaises.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext.getCurrentInstance().getViewRoot()
                        .setLocale((Locale) entry.getValue());
            }
        }
    }
}
