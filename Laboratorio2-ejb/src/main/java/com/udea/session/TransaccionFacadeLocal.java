/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Transaccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Santiago
 */
@Local
public interface TransaccionFacadeLocal {

    void create(Transaccion transaccion);

    void edit(Transaccion transaccion);

    void remove(Transaccion transaccion);

    Transaccion find(Object id);

    List<Transaccion> findAll();

    List<Transaccion> findRange(int[] range);

    int count();
    
    List<Transaccion> getTransacciones();

    List<Transaccion> listTransaccionById(int idUsuario);

    void transaccion(int idCliente, int idCarro);
}
