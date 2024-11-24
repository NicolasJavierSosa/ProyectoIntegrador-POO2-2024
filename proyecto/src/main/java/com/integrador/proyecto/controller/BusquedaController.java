package com.integrador.proyecto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.Producto;

@Controller
public class BusquedaController {
    @GetMapping("/buscar")
    public String buscar(@RequestParam("query") String query, Model model) {
        // Lógica de búsqueda, por ejemplo, buscar productos que coincidan o sean similares
        List<Producto> resultados = realizarBusqueda(query);
        
        model.addAttribute("resultados", resultados);
        model.addAttribute("query", query);
        
        return "resultadosBusqueda";  // La vista HTML que muestra los resultados
    }

    private List<Producto> realizarBusqueda(String query) {
        // Ejemplo de productos ficticios (en un escenario real, estos vendrían de la base de datos)
        List<Producto> productos = new ArrayList<>();
        /*productos.add(new Producto(1, "Mueble de Sala", "Mueble elegante para sala", "/img/mueble-sala.jpg"));
        productos.add(new Producto(2, "Mueble de Cocina", "Mueble de madera para cocina", "/img/mueble-cocina.jpg"));
        productos.add(new Producto(3, "Mueble de Oficina", "Mueble funcional para oficina", "/img/mueble-oficina.jpg"));*/

        // Filtramos los productos que contienen la búsqueda (simulación simple)
        return productos.stream()
                        .filter(p -> p.getNombre().toLowerCase().contains(query.toLowerCase()))
                        .collect(Collectors.toList());
    }
}
