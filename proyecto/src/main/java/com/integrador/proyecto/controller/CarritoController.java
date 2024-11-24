package com.integrador.proyecto.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.NoArgsConstructor;


@Controller
@NoArgsConstructor
public class CarritoController {

    @GetMapping("/carrito")
    public String inicio(){
        return "carrito";
    }

    /*@GetMapping("/carrito")
    public String mostrarProductos(Model model){
        List<Producto> productos = new ArrayList<>();
		productos.add(new Producto("Lechuga", "Es una verdura man media pila", 100.50, 0.45));
        productos.add(new Producto("Tomate", "Es una fruta man media pila", 1070.50, 0.50));
        model.addAttribute("productos", productos);
        return "carrito";
    }*/

}
