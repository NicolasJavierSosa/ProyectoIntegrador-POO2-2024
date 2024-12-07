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
    public String mostrarCatalogo(
            @RequestParam(required = false) String buscar,
            @RequestParam(required = false) String ordenar,
            @RequestParam(required = false) String categoria,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamaño,
            Model model) {

        List<Producto> productos;
                
        // More concise filtering logic using a ternary operator
        productos = (categoria != null && !categoria.isEmpty()) ? 
                    productoServicio.buscarPorCategoria(categoria) :
                    (buscar != null && !buscar.isEmpty()) ?
                    productoServicio.buscarPorNombre(buscar) :
                    ("menor-precio".equals(ordenar)) ?
                    productoServicio.ordenarPorPrecioAsc() :
                    ("mayor-precio".equals(ordenar)) ?
                    productoServicio.ordenarPorPrecioDesc() :
                    productoServicio.obtenerTodosProductos();


        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaServicio.obtenerTodasCategorias());
        model.addAttribute("categoriaSeleccionada", categoria);

        return "catalogo";
    }

    

}