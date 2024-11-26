package com.integrador.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.integrador.proyecto.servicio.ProductoServicio;

import lombok.NoArgsConstructor;
import modelo.Producto;

@Controller
@NoArgsConstructor
public class OrdenController {

    @Autowired
    private ProductoServicio productoServicio;

   @GetMapping("/orden/{id}")
    public String mostrarOrden(@PathVariable String id, Model model) {
        // Obtener la información del producto por su ID
        Producto producto = productoServicio.obtenerProductoPorId(id);

        // Agregar la información del producto al modelo
        model.addAttribute("producto", producto);

        // Redirigir al archivo HTML de la orden
        return "orden"; // Nombre del archivo orden.html en la carpeta templates
    }

}
