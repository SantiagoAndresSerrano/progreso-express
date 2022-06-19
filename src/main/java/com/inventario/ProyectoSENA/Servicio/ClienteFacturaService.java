/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventario.ProyectoSENA.Servicio;

import com.inventario.ProyectoSENA.Modelo.ClienteFactura;
import java.util.List;

/**
 *
 * @author johnny
 */

public interface ClienteFacturaService {
    public List<ClienteFactura> getClientesFacturas();
    public List<ClienteFactura> buscarClienteFactura(int idCliente);
    public ClienteFactura guardarClienteFactura(ClienteFactura clienteFactura);
    
}
