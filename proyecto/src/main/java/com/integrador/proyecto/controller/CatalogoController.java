package com.integrador.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.NoArgsConstructor;

@Controller
@NoArgsConstructor
public class CatalogoController {

    @GetMapping("/catalogo")
    public String inicio(){
        return "catalogo";
    }

}
