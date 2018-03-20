/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.Carro;
import com.udea.Cliente;
import com.udea.Transaccion;
import com.udea.session.CarroFacadeLocal;
import com.udea.session.ClienteFacadeLocal;
import com.udea.session.TransaccionFacadeLocal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Santiago
 */
public class controllerBean {
    
    @EJB
    private TransaccionFacadeLocal transaccionFacade;
    
    @EJB
    private ClienteFacadeLocal clienteFacade;
    
    @EJB
    private CarroFacadeLocal carroFacade;

    /**
     * Creates a new instance of controllerBean
     */
    private Carro carro;
    private List<Carro> carros;
    private Cliente cliente;
    private List<Cliente> clientes;
    private Transaccion transaccion;
    private List<Transaccion> transacciones;
    
    public controllerBean() {
    }
    
    public String login(int i, String p) {
        System.out.println("###LOGIN###");
        if (check(i, p)) {
            //this.verCarro();
            return "LOGIN";
        } else {
            return "ERROR";
        }
    }
    
    public boolean check(int a, String b) {
        return clienteFacade.checkLogin(a, b);
    }
    
    public String crearTransaccion(int idCliente,int idCarro){
        transaccionFacade.transaccion(idCliente,idCarro);
        return "GUARDAR";
    }
    
    public String signup(int cedula, String password, String nombre, String ciudad, String telefono, String email) {
        clienteFacade.registrar(cedula, password, nombre, ciudad, telefono, email);
        return "REGISTRAR";
    }
    
    public void refresh() {
        carros = carroFacade.getCarros();
    }
    
    public List<Carro> getCarros() {
        refresh();
        return carros;        
    }
    
    public void Catalogo() {
        carros = carroFacade.getCarros();     
    }
    
    public String verTransaccion(int i) {
        //List<Transaccion> transacciones;
        transacciones = this.transaccionesById(i);
        return "HISTORIAL";
    }

//    List<Carro> carros() {
//        return carroFacade.getCarros();
//    }
    
    List<Transaccion> transacciones() {
        return transaccionFacade.getTransacciones();
    }

    public List<Transaccion> transaccionesById(int cedula) {
        return transaccionFacade.listTransaccionById(cedula);
    }
//    public String imgen(){
//    
//    return carro.getFotoBase64();
//    
//    }
    
    public String salir(){
        return "SALIR";
    }
    
    
}
