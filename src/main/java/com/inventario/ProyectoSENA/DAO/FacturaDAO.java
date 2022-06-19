/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventario.ProyectoSENA.DAO;

import com.inventario.ProyectoSENA.Modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author johnny
 */
public interface FacturaDAO extends JpaRepository<Factura,Integer> {
    
}
