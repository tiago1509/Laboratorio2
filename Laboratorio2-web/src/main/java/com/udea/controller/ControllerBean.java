/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.session.ClienteFacadeLocal;
import com.udea.session.TransaccionFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Santiago
 */
@Named(value = "controllerBean")
@SessionScoped
public class ControllerBean implements Serializable {

    @EJB
    private TransaccionFacadeLocal transaccionFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @EJB
    private com.udea.session.CarroFacadeLocal carroFacade;

    /**
     * Creates a new instance of ControllerBean
     */
    
    
    public ControllerBean() {
    }
    
}
