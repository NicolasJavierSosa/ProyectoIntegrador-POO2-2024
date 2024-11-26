package com.integrador.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SesionController {
    @GetMapping("/sesion")
    public String mostrarSesion() {
        return "sesion";
    }
    

}
