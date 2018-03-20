/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Carro;
import com.udea.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "com.udea_Laboratorio2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public Cliente getClienteById(int idCliente) {       
        Query q = em.createNamedQuery("Cliente.findByCedula");        
        return (Cliente) q.getSingleResult();
    }

    @Override
    public void registrar(final int cedula, String password, String nombre, String ciudad, String telefono, String email) {
        Cliente c = new Cliente();
        
        c.setCedula(cedula);
        c.setPassword(password);
        c.setNombre(nombre);
        c.setCiudad(ciudad);
        c.setTelefono(telefono);
        c.setEmail(email);
        
        em.persist(c);      
    }

    @Override
    public boolean checkLogin(int cedula, String password) {
        Query q =em.createQuery("select a from Cliente a"
            + " where a.cedula=:cedula and a.password=:password");
        q.setParameter("cedula", cedula);
        q.setParameter("password", password);       
       return q.getResultList().size()>0;
    }

    @Override
    public List<Cliente> getCliente() {
        Query q = em.createNamedQuery("Cliente.findAll");
        return q.getResultList();
    }

    @Override
    public List<Cliente> getClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}