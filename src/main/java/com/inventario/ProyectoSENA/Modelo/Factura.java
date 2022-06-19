/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.ProyectoSENA.Modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author johnny
 */
@Entity
@Table(name = "factura")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total"),
    @NamedQuery(name = "Factura.findByDescuento", query = "SELECT f FROM Factura f WHERE f.descuento = :descuento")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @Column(name = "descuento")
    private int descuento;
    @Basic(optional = false)
    @Column(name = "concepto")
    private String concepto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private Collection<ClienteFactura> clienteFacturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private Collection<DetalleProducto> detalleProductoCollection;

    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Factura(Integer id, Date fecha, int total, int descuento, String concepto) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.descuento = descuento;
        this.concepto = concepto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    

    public Collection<ClienteFactura> ClienteFacturaCollection() {
        return clienteFacturaCollection;
    }

    public void ClienteFacturaCollection(Collection<ClienteFactura> clienteFacturaCollection) {
        this.clienteFacturaCollection = clienteFacturaCollection;
    }

    public Collection<DetalleProducto> DetalleProductoCollection() {
        return detalleProductoCollection;
    }

    public void DetalleProductoCollection(Collection<DetalleProducto> detalleProductoCollection) {
        this.detalleProductoCollection = detalleProductoCollection;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inventario.ProyectoSENA.Modelo.Factura[ id=" + id + " ]";
    }
    
}
