package com.inventario.ProyectoSENA.Controlador;

import com.inventario.ProyectoSENA.Implementacion.ProductoImp;
import com.inventario.ProyectoSENA.Modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    @Autowired
    ProductoImp productoImp;

    @GetMapping("productos")
    public ResponseEntity<?> getProducto(){
        return ResponseEntity.ok(this.productoImp.getProducto());
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id){
        this.productoImp.eliminarProdcuto(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

    @PostMapping("guardar")
    public ResponseEntity<?> guardarProducto(@RequestBody Producto producto){
        this.productoImp.guardarProducto(producto);
        return ResponseEntity.ok("Producto Registrado " + producto);
    }

    @PostMapping("actualizar")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto){
        this.productoImp.guardarProducto(producto);
        return ResponseEntity.ok("Producto Actualizado " + producto);
    }
}
