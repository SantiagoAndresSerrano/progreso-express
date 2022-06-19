/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventario.ProyectoSENA.Servicio;

import com.inventario.ProyectoSENA.Modelo.DetalleProducto;
import com.inventario.ProyectoSENA.Modelo.Factura;
import com.inventario.ProyectoSENA.Modelo.ProductoId;
import java.util.List;

/**
 *
 * @author johnny
 */
public interface DetalleProductoService {
    
    public void guardarProductos(Factura factura, List<ProductoId> productos);
    public List<DetalleProducto> getDetallesProductos();
    public int getTotalFactura(int idFactura);
}
