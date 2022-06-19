package com.inventario.ProyectoSENA.Implementacion;

import com.inventario.ProyectoSENA.DAO.ProductoDAO;
import com.inventario.ProyectoSENA.Modelo.Producto;
import com.inventario.ProyectoSENA.Servicio.ProductoService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoImp implements ProductoService {

    @Autowired
    ProductoDAO productoDAO;

    @Override
    public List<Producto> getProducto() {
        
        List<Producto> list = new ArrayList<>();
        for(Producto p: this.productoDAO.findAll()){
            if(p.getEstado().equals("activo"))
                list.add(p);
        }
        return list;
    }

    @Override
    public void guardarProducto(Producto producto) {
        this.productoDAO.save(producto);
    }

    @Override
    public Optional<Producto> encontrarProducto(int id) {
        return this.productoDAO.findById(id);
    }
    @Override
    public void eliminarProdcuto(int id) {
        Optional<Producto> prod = this.encontrarProducto(id);
        System.out.println(prod);
        prod.get().setEstado("inactivo");
        this.guardarProducto(prod.get());
    }

}
