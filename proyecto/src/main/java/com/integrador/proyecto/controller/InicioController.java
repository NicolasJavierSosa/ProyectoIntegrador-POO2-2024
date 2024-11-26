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

import com.integrador.proyecto.servicio.PaqueteServicio;
import com.integrador.proyecto.servicio.ProductoServicio;

import lombok.NoArgsConstructor;
import modelo.Producto;

@Controller
@NoArgsConstructor
public class InicioController {

    private ProductoServicio serviceProd;
    private PaqueteServicio servicePaq;

    @Autowired
    InicioController(ProductoServicio serviceProd, PaqueteServicio servicePaq){
        this.serviceProd = serviceProd;
        this.servicePaq = servicePaq;
    }

    @GetMapping({"/", "/inicio"})
    public String inicio(Model model){
        List<Producto> productos = serviceProd.obtenerProductos();
        List<Producto> productosDes = new ArrayList<>();
        for(int i = 0; i < productos.size(); i++){
            if(productos.get(i).getPrecio() < 500.00 && productosDes.size() < 6){
                productosDes.add(productos.get(i));
            }
        }
        model.addAttribute("productosDes", productosDes);
        return "inicio";
    }

    @PostMapping("/inicio/agregar")
    @ResponseBody
    public ResponseEntity<String> agregarProductoAlCarrito(@RequestBody Map<String, String> data){
        String id = data.get("id");
        servicePaq.agregarCompra(serviceProd.obtenerProductoPorId(id));
        return ResponseEntity.ok("Se cargó " + serviceProd.obtenerProductoPorId(id).getNombre() + " al carrito");        
        
    }
}
