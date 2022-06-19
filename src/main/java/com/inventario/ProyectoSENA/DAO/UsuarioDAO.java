/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventario.ProyectoSENA.DAO;

import com.inventario.ProyectoSENA.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author johnny
 */

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{
    
}
