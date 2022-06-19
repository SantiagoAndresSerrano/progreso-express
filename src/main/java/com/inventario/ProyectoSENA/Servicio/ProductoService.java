package com.inventario.ProyectoSENA.Servicio;

import com.inventario.ProyectoSENA.Modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductoService {
    public List<Producto> getProducto();
    public void guardarProducto(Producto producto);
    public Optional<Producto> encontrarProducto(int id);
    public void eliminarProdcuto(int id);
}
