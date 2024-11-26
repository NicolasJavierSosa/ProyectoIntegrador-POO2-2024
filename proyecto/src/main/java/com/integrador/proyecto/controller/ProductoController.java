package com.integrador.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.proyecto.servicio.ProductoServicio;

import modelo.Producto;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private final ProductoServicio productoService;

    public ProductoController(ProductoServicio productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/producto/{id}")
    public String mostrarProducto(@PathVariable String id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        if (producto != null) {
            model.addAttribute("producto", producto);
            return "producto"; // Nombre de la plantilla HTML (producto.html)
        } else {
            return "error"; // Redirigir a una página de error si el producto no existe
        }
    }

    @GetMapping("/catalogo")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("productos", productoService.obtenerProductos());
        return "catalogo";
    }
}
