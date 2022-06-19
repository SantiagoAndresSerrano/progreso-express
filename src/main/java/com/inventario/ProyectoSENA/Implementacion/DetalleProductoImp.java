/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.ProyectoSENA.Implementacion;

import com.inventario.ProyectoSENA.DAO.DetalleProductoDAO;
import com.inventario.ProyectoSENA.Modelo.DetalleProducto;
import com.inventario.ProyectoSENA.Modelo.Factura;
import com.inventario.ProyectoSENA.Modelo.Producto;
import com.inventario.ProyectoSENA.Modelo.ProductoId;
import com.inventario.ProyectoSENA.Servicio.DetalleProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johnny
 */
@Service
public class DetalleProductoImp implements DetalleProductoService{

    @Autowired
    DetalleProductoDAO detalleProductoDAO;
    
    @Autowired
    ProductoImp productoImp;
    
    @Override
    public void guardarProductos(Factura factura, List<ProductoId> idproductos) {
        
        for(int i = 0; i < idproductos.size(); i++){
            int cntProducto = 0;
            for(int j = i; j < idproductos.size(); j++){
                if(idproductos.get(i).getIdProducto() == idproductos.get(j).getIdProducto()) cntProducto++;
            }
            Producto ingresa = this.productoImp.encontrarProducto(idproductos.get(i).getIdProducto()).get();
            DetalleProducto detalleProducto = new DetalleProducto(0, ingresa.getPrecioVenta() , cntProducto);
            System.out.println(cntProducto);
            ingresa.setCantidad(ingresa.getCantidad()-cntProducto);
            this.productoImp.guardarProducto(ingresa);
            detalleProducto.setIdProducto(ingresa);
            detalleProducto.setIdFactura(factura);
            this.detalleProductoDAO.save(detalleProducto);
        }
    }

    @Override
    public List<DetalleProducto> getDetallesProductos() {
        return this.detalleProductoDAO.findAll();
    }

    @Override
    public int getTotalFactura(int idFactura) {
        int total = 0;
        List<DetalleProducto> deta = this.getDetallesProductos();
        for(DetalleProducto detap:deta){
            if(detap.getIdFactura().getId() == idFactura) total += detap.getCosto();
        }
        return total;
    }
    
}
