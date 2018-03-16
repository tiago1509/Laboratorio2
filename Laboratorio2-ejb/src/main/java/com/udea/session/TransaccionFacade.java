/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Carro;
import com.udea.Cliente;
import com.udea.Transaccion;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Santiago
 */
@Stateless
public class TransaccionFacade extends AbstractFacade<Transaccion> implements TransaccionFacadeLocal {

    @PersistenceContext(unitName = "com.udea_Laboratorio2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionFacade() {
        super(Transaccion.class);
    }
    
    public List<Transaccion> getTransacciones(){
        Query q = em.createNamedQuery("Transaccion.findAll");
        return q.getResultList();
    }

    @Override
    public List<Transaccion> listTransaccionById(int idUsuario) {
        Query q =em.createQuery("select a from Transaccion a where a.idUsuario=:idUsuario");
        q.setParameter("idUsuario", idUsuario);      
        return q.getResultList();
    }

    @Override
    public void transaccion(int idCliente, int idCarro) {
        Transaccion t = new Transaccion();
//        Cliente c = new Cliente();
//        Carro ca = new Carro();        
//        c.setCedula(idCliente);
//        ca.setMatricula(idCarro);
        
        t.setCodigo(0);
        t.setIdCarro(idCarro);
        t.setIdCliente(idCliente);
        
        java.util.Date fecha = new Date();
        t.setFecha(fecha);
        
        em.persist(t);      
    }
    
    
    
}
