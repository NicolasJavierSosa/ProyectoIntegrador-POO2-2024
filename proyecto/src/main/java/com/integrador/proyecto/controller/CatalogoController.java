package com.integrador.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.integrador.proyecto.servicio.CategoriaServicio;
import com.integrador.proyecto.servicio.ProductoServicio;

import lombok.NoArgsConstructor;
import modelo.Producto;

@Controller
@NoArgsConstructor
public class CatalogoController {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("/catalogo")
    public String mostrarCatalogo(@RequestParam(required = false) String buscar,
                                  @RequestParam(required = false) String ordenar,
                                  @RequestParam(defaultValue = "0") int pagina,
                                  @RequestParam(defaultValue = "10") int tamaño,
                                  Model model) {
        List<Producto> productos;

        // Filtro por búsqueda de nombre
        if (buscar != null && !buscar.isEmpty()) {
            productos = productoServicio.buscarPorNombre(buscar);
        }
        // Filtro por ordenación (precio)
        else if ("menor-precio".equals(ordenar)) {
            productos = productoServicio.ordenarPorPrecioAsc();
        } else if ("mayor-precio".equals(ordenar)) {
            productos = productoServicio.ordenarPorPrecioDesc();
        } else {
            productos = productoServicio.obtenerTodosProductos();
        }

        // Agregar productos y categorías al modelo
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaServicio.obtenerTodasCategorias());

        return "catalogo";
    }

}
