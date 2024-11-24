package com.integrador.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NoController {

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }
    // Ruta para el login o la sesión
    @GetMapping("/sesion")
    public String mostrarSesion() {
        return "sesion";  // Retorna el archivo sesion.html
    }

    @GetMapping("/catalogo")
    public String mostrarcatalogo() {
        return "catalogo";  // Retorna el archivo sesion.html
    }
    
}