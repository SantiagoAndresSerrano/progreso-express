/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.ProyectoSENA.Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author johnny
 */
@Entity
@Table(name = "detalleProducto")
@NamedQueries({
    @NamedQuery(name = "DetalleProducto.findAll", query = "SELECT d FROM DetalleProducto d"),
    @NamedQuery(name = "DetalleProducto.findById", query = "SELECT d FROM DetalleProducto d WHERE d.id = :id"),
    @NamedQuery(name = "DetalleProducto.findByCosto", query = "SELECT d FROM DetalleProducto d WHERE d.costo = :costo"),
    @NamedQuery(name = "DetalleProducto.findByCantidad", query = "SELECT d FROM DetalleProducto d WHERE d.cantidad = :cantidad")})
public class DetalleProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "costo")
    private int costo;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idFactura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factura idFactura;
    @JoinColumn(name = "idProducto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public DetalleProducto() {
    }

    public DetalleProducto(Integer id) {
        this.id = id;
    }

    public DetalleProducto(Integer id, int costo, int cantidad) {
        this.id = id;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProducto)) {
            return false;
        }
        DetalleProducto other = (DetalleProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.ProyectoSENA.Modelo.DetalleProducto[ id=" + id + " ]";
    }
    
}
