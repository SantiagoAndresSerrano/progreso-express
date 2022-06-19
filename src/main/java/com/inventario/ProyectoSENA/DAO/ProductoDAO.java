package com.inventario.ProyectoSENA.DAO;

import com.inventario.ProyectoSENA.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDAO extends JpaRepository<Producto,Integer> {

}
