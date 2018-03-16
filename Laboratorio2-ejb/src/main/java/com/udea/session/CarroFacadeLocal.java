/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Carro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santiago
 */
@Local
public interface CarroFacadeLocal {

    void create(Carro carro);

    void edit(Carro carro);

    void remove(Carro carro);

    Carro find(Object id);

    List<Carro> findAll();

    List<Carro> findRange(int[] range);

    int count();
    
    List<Carro> getCarros();

    Carro getCarroById(int idCarro);
}
