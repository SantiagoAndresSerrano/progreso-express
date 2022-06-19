/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventario.ProyectoSENA.Servicio;

import com.inventario.ProyectoSENA.Modelo.Factura;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author johnny
 */
public interface FacturaService {
    public List<Factura> getFacturas();
    public Factura getFactura(int idFactura);
    public Factura guardar(Factura factura);
}
