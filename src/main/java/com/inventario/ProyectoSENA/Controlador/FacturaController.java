/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.ProyectoSENA.Controlador;

import com.inventario.ProyectoSENA.Implementacion.ClienteFacturaImp;
import com.inventario.ProyectoSENA.Implementacion.DetalleProductoImp;
import com.inventario.ProyectoSENA.Implementacion.FacturaImp;
import com.inventario.ProyectoSENA.Implementacion.UsuarioImp;
import com.inventario.ProyectoSENA.Modelo.ClienteFactura;
import com.inventario.ProyectoSENA.Modelo.Factura;
import com.inventario.ProyectoSENA.Modelo.ProductoId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johnny
 */
@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController {
    
    @Autowired
    FacturaImp facturaImp;
    
    @Autowired
    DetalleProductoImp detalleProductoImp;
    
    @Autowired
    ClienteFacturaImp clienteFacturaImp;
    
    @Autowired
    UsuarioImp usuarioImp;
    
    @GetMapping("facturas")
    public ResponseEntity<?> getFacturas(){
        return ResponseEntity.ok(this.facturaImp.getFacturas());
    }
    
    @GetMapping("generarFactura")
    public ResponseEntity<?> generarFactura(@RequestBody String concepto){
        Date date = new Date();
        Factura factura = new Factura(0, date, 0, 0, concepto);
        int id = this.facturaImp.guardar(factura).getId();
        return ResponseEntity.ok(id);
    }
    
    @PostMapping("pedido/{idfactura}/{idCliente}")
    public ResponseEntity<?> guardarPedido(@PathVariable Integer idfactura, @PathVariable Integer idCliente, @RequestBody List<ProductoId> idproducts){
        this.detalleProductoImp.guardarProductos(this.facturaImp.getFactura(idfactura), idproducts);
        Factura fac = this.facturaImp.getFactura(idfactura);
        fac.setTotal(this.detalleProductoImp.getTotalFactura(idfactura));
        this.facturaImp.guardar(fac);
        ClienteFactura clienteFactura = new ClienteFactura();
        clienteFactura.setIdCliente(this.usuarioImp.buscarUsuario(idCliente));
        clienteFactura.setIdFactura(fac);
        this.clienteFacturaImp.guardarClienteFactura(clienteFactura);
        return ResponseEntity.ok("añadidos");
    }
    
    @GetMapping("detalleproductos")
    public ResponseEntity<?> getDetallesProductos(){
        return ResponseEntity.ok(this.detalleProductoImp.getDetallesProductos());
    }
}
