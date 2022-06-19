/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventario.ProyectoSENA.Implementacion;

import com.inventario.ProyectoSENA.DAO.ClienteFacturaDAO;
import com.inventario.ProyectoSENA.Modelo.ClienteFactura;
import com.inventario.ProyectoSENA.Servicio.ClienteFacturaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johnny
 */
@Service
public class ClienteFacturaImp implements ClienteFacturaService{

    @Autowired
    ClienteFacturaDAO clienteFacturaDAO;
    
    @Override
    public List<ClienteFactura> getClientesFacturas() {
        return this.clienteFacturaDAO.findAll();
    }

    @Override
    public List<ClienteFactura> buscarClienteFactura(int idCliente) {
        List<ClienteFactura> cliente = new ArrayList<>();
        for(ClienteFactura cf:this.getClientesFacturas()){
            if(cf.getIdCliente().getId() == idCliente) cliente.add(cf);
        }
        return cliente;
    }

    @Override
    public ClienteFactura guardarClienteFactura(ClienteFactura clienteFactura) {
        this.clienteFacturaDAO.save(clienteFactura);
        return clienteFactura;
    }
    
}
