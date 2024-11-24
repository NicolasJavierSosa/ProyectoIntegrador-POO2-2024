package com.integrador.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.integrador.proyecto.servicio.ProductoServicio;

import lombok.NoArgsConstructor;
import modelo.Producto;

@Controller
@NoArgsConstructor
public class InicioController {

    private ProductoServicio service;

    InicioController(ProductoServicio service){
        this.service = service;
    }

    @GetMapping({"/", "/inicio"})
    public String inicio(Model model){
        List<Producto> productos = new ArrayList<>();
		productos.add(new Producto("Lechuga", "Es una verdura man media pila", 100.50, 0.45));
        productos.add(new Producto("Tomate", "Es una fruta man media pila", 1070.50, 0.50));
        productos.add(new Producto("Arveja", "wtf re pesada la arveja", 1500.50, 1.50));
        System.out.println(productos);
        model.addAttribute("productos", productos);
        return "inicio";
    }
}
