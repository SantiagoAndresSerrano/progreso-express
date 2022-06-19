/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.ProyectoSENA.Implementacion;

import com.inventario.ProyectoSENA.DAO.FacturaDAO;
import com.inventario.ProyectoSENA.Modelo.Factura;
import com.inventario.ProyectoSENA.Servicio.FacturaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johnny
 */
@Service
public class FacturaImp implements FacturaService {

    @Autowired
    FacturaDAO facturaDao;
    
    @Override
    public List<Factura> getFacturas() {
        return this.facturaDao.findAll();
    }

    @Override
    public Factura guardar(Factura factura) {
        return this.facturaDao.save(factura);
    }

    @Override
    public Factura getFactura(int idFactura) {
        return this.facturaDao.findById(idFactura).get();
    }
    
    
}
