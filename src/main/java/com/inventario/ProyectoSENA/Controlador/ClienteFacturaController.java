/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.ProyectoSENA.Controlador;

import com.inventario.ProyectoSENA.Implementacion.ClienteFacturaImp;
import com.inventario.ProyectoSENA.Implementacion.FacturaImp;
import com.inventario.ProyectoSENA.Modelo.ClienteFactura;
import static com.inventario.ProyectoSENA.Modelo.ClienteFactura_.idCliente;
import com.inventario.ProyectoSENA.Modelo.Factura;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johnny
 */
@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteFacturaController {
    
    @Autowired
    ClienteFacturaImp clienteFacturaImp;
    
    @Autowired
    FacturaImp facturaImp;
    
    @GetMapping("facturasadmin")
    public ResponseEntity<?> getClientesFacturas(){
        return ResponseEntity.status(HttpStatus.OK)
                                        .body(this.clienteFacturaImp.getClientesFacturas());
    }
    
    @GetMapping("factura/{idCliente}")
    public ResponseEntity<?> getClientefactura(@PathVariable String idCliente){
        List<ClienteFactura> clienteFacturas = this.clienteFacturaImp.buscarClienteFactura(Integer.parseInt(idCliente));
        List<Factura> facturasCliente = new ArrayList<>();
        for(ClienteFactura cf:clienteFacturas){
            facturasCliente.add(this.facturaImp.getFactura(cf.getIdFactura().getId()));
        }
        System.out.println(facturasCliente.get(0));
        return ResponseEntity.status(HttpStatus.OK)
                                        .body(facturasCliente);
    }
}
