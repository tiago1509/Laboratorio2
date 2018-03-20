/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findByCodigo", query = "SELECT t FROM Transaccion t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Transaccion.findByFecha", query = "SELECT t FROM Transaccion t WHERE t.fecha = :fecha")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_carro", referencedColumnName = "matricula")
    @ManyToOne
    private Carro idCarro;
    @JoinColumn(name = "id_cliente", referencedColumnName = "cedula")
    @ManyToOne
    private Cliente idCliente;

    public Transaccion() {
    }

    public Transaccion(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdCarro() {
        return this.idCarro.getMatricula();
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro.setMatricula(idCarro);
    }   
    
    public Integer getIdCliente() {
        return this.idCliente.getCedula();
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente.setCedula(idCliente);
    }
    
    public Integer getCarro() {
        return this.idCarro.getMatricula();
    }
    
    public void setCarro(int idMatricula) {
        this.idCarro = new Carro(idMatricula);
    }
    
    public Integer getCliente() {
        return this.idCliente.getCedula();
    }
    
    public void setCliente(int idCliente) {
        this.idCliente = new Cliente(idCliente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.Transaccion[ codigo=" + codigo + " ]";
    }
    
}
