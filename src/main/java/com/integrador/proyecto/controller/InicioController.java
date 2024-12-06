package com.integrador.proyecto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import modelo.Producto;

@Controller
@NoArgsConstructor
public class InicioController {

    private ProductoServicio serviceProd;
    private CategoriaServicio serviceCat;


    @Autowired
    InicioController(ProductoServicio serviceProd, CategoriaServicio serviceCat){
        this.serviceProd = serviceProd;
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
    public ResponseEntity<String> agregarProductoAlCarrito(@RequestBody Map<String, Integer> datos, HttpSession sesion){
        int id = datos.get("idProducto");
        int cant;

        try {
            cant = datos.get("cantidad");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Cantidad inválida.");
        }

        if (cant <= 0) {
            return ResponseEntity.badRequest().body("La cantidad debe ser mayor a 0.");
        }

        Producto prod = serviceProd.obtenerProductoPorId(id);
        if(prod != null){
            if(cant > prod.getCantDisp()){
                return ResponseEntity.badRequest().body("No quedan suficientes unidades en stock, por favor ingrese una cantidad más pequeña o intente de nuevo en otro momento");
            }
            else{
                for(int i = 0; i < cant; i++){
                    prod.setCantDisp(prod.getCantDisp() - cant);
                }
            }
            List<Producto> compra = (List<Producto>) sesion.getAttribute("compra");

            if(compra == null){
                compra = new ArrayList<>();
                sesion.setAttribute("compra", compra);
            }

            for (int i = 0; i < cant; i++) {
                compra.add(prod);
            }
            sesion.setAttribute("compra", compra);
            return ResponseEntity.ok("Se cargaron " + cant + " unidades de " + prod.getNombre() + " al carrito.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado.");
    }
}
