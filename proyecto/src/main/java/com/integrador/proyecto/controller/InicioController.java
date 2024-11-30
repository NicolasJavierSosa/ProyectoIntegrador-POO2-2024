package com.integrador.proyecto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrador.proyecto.servicio.CategoriaServicio;
import com.integrador.proyecto.servicio.PaqueteServicio;
import com.integrador.proyecto.servicio.ProductoServicio;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import modelo.Categoria;
import modelo.Paquete;
import modelo.Producto;

@Controller
@NoArgsConstructor
public class InicioController {

    private ProductoServicio serviceProd;
    private PaqueteServicio servicePaq;
    private CategoriaServicio serviceCat;


    @Autowired
    InicioController(ProductoServicio serviceProd, PaqueteServicio servicePaq, CategoriaServicio serviceCat){
        this.serviceProd = serviceProd;
        this.servicePaq = servicePaq;
        this.serviceCat = serviceCat;
    }

    @GetMapping({"/", "/inicio"})
    public String inicio(Model model){
        List<Producto> productos = serviceProd.obtenerProductos();
        List<Producto> productosDes = new ArrayList<>();
        List<Categoria> categorias = serviceCat.obtenerTodasCategorias();
        for(int i = 0; i < productos.size(); i++){
            if(productos.get(i).getPrecio() < 5000.00 && productosDes.size() < 6){
                productosDes.add(productos.get(i));
            }
        }
        model.addAttribute("categorias", categorias);
        model.addAttribute("productosDes", productosDes);
        return "inicio";
    }

    @PostMapping("/inicio/agregar")
    @ResponseBody
    public ResponseEntity<String> agregarProductoAlCarrito(@RequestBody Map<String, String> idProducto, HttpSession sesion){
        String id = idProducto.get("idProducto");
        Paquete compra = (Paquete) sesion.getAttribute("compra");
        if (compra == null) {
            compra = new Paquete();
            sesion.setAttribute("compra", compra);
        }
        compra.añadirItem(serviceProd.obtenerProductoPorId(id));
        sesion.setAttribute("compra", compra);
        servicePaq.guardarPaquete(compra);
        return ResponseEntity.ok("Se cargó " + serviceProd.obtenerProductoPorId(id).getNombre() + " al carrito");
    }
}
