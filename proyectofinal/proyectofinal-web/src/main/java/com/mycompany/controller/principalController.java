/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author DaveHell
 */
@Named(value = "principalController")
@RequestScoped
public class principalController {
    
     private PieChartModel pieModel1;

     public principalController() {
        pieModel1 = new PieChartModel();
    }
     
     
    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    /**
     * Creates a new instance of principalController
     * @param pieModel1
     */
    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }
    
    
    
    @PostConstruct
    public void llenar(){
        pieModel1.set("Bajo Peso", 2);
        pieModel1.set("No se", 100);
        pieModel1.setTitle("IMC");
        pieModel1.setLegendPosition("e");
        pieModel1.setShadow(false);
    }
    
}
