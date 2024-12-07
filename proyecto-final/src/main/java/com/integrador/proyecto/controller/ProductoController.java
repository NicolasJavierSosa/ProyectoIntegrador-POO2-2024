package com.integrador.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.integrador.proyecto.servicio.ProductoServicio;
import jakarta.servlet.http.HttpSession;
import modelo.Producto;
import modelo.Usuario;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private final ProductoServicio productoService;

    public ProductoController(ProductoServicio productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/producto/{id}")
    public String mostrarProducto(@PathVariable Integer id, HttpSession session, Model model) {
        // Obtener el producto
        Producto producto = productoService.obtenerProductoPorId(id);
        
        // Obtener el usuario desde la sesión
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (producto != null) {
            model.addAttribute("producto", producto);

            // Si hay un usuario autenticado, se agrega al modelo
            if (usuario != null) {
                model.addAttribute("usuario", usuario);
            }

            return "producto"; // Nombre de la plantilla HTML (producto.html)
        } else {
            return "error"; // Redirigir a una página de error si el producto no existe
        }
    }

    @GetMapping("/catalogo")
    public String mostrarCatalogo(HttpSession session, Model model) {
        // Obtener la lista de productos
        model.addAttribute("productos", productoService.obtenerProductos());

        // Obtener el usuario desde la sesión
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        // Si hay un usuario autenticado, se agrega al modelo
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        }

        return "catalogo"; // Nombre de la plantilla HTML (catalogo.html)
    }
}
