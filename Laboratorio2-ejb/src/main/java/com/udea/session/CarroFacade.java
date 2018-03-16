/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Carro;
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
public class CarroFacade extends AbstractFacade<Carro> implements CarroFacadeLocal {

    @PersistenceContext(unitName = "com.udea_Laboratorio2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarroFacade() {
        super(Carro.class);
    }
    
    public List<Carro> getCarros(){
        Query q = em.createNamedQuery("Carro.findAll");
        return q.getResultList();
    }

    @Override
    public Carro getCarroById(int idCarro) {
        Query q = em.createNamedQuery("Carro.findByMatricula");        
        return (Carro) q.getSingleResult();
    }
    
    
}
