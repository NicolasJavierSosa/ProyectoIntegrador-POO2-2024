package com.integrador.proyecto.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrador.proyecto.servicio.ProductoServicio;

import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import modelo.DescuentoTemporada;
import modelo.DescuentoVolumen;
import modelo.DetallePedido;
import modelo.PedidoBase;
import modelo.Producto;
import modelo.Usuario;

@Controller
@NoArgsConstructor
public class CarritoController {
    private ProductoServicio productoServicio;

    @GetMapping("/carrito/stock/{idProducto}")
@ResponseBody
public ResponseEntity<Integer> obtenerStock(@PathVariable Integer idProducto) {
    Producto producto = productoServicio.obtenerProductoPorId(idProducto);
    if (producto == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);
    }
    return ResponseEntity.ok(producto.getCantDisp());
}
    @GetMapping("/carrito")
    public String inicio(HttpSession sesion, Model model) {


        DetallePedido detalle = (DetallePedido) sesion.getAttribute("detalle");

        if (detalle != null) {
            detalle.vaciar();
        } else {
            detalle = new DetallePedido();
            sesion.setAttribute("detalle", detalle);
        }

        List<Producto> compra = (List<Producto>) sesion.getAttribute("compra");

        if (compra != null) {
            // Agrupar productos por nombre y calcular cantidad y subtotal
            Map<String, List<Producto>> productosAgrupados = compra.stream()
                    .collect(Collectors.groupingBy(Producto::getNombre));

            List<Map<String, Object>> comprasAgrupadas = new ArrayList<>();
            PedidoBase pedido = new PedidoBase();
            DescuentoTemporada pedidoTemporada = new DescuentoTemporada();
            double totalCarrito = 0;
            double subtotalCarrito = 0;
            double pesoTotal = 0;

            for (Map.Entry<String, List<Producto>> entry : productosAgrupados.entrySet()) {
                String nombre = entry.getKey();
                List<Producto> productos = entry.getValue();
                int cantidad = productos.size();
                double precio = productos.get(0).getPrecio();
                double subtotal = precio * cantidad;
                double descVolumen = 0;
                double descTemporada = 0;
                double totalProducto = 0;

                pedido.setCantidad(cantidad);
                pedido.setSubtotal(subtotal);
                pedido.setPesoSubtotal(productos.get(0).getPeso() * cantidad);
                pesoTotal += productos.get(0).getPeso() * cantidad;

                if (LocalDateTime.now().isAfter(pedidoTemporada.getFechaInicio())
                        && LocalDateTime.now().isBefore(pedidoTemporada.getFechaFin())) {
                    pedidoTemporada = new DescuentoTemporada(pedido);
                    totalCarrito += Math.round(pedidoTemporada.getPrecio());
                    descTemporada = Math.round(pedidoTemporada.getDescuento());
                    totalProducto = Math.round(pedidoTemporada.getPrecio());
                }
                if (pedido.getCantidad() >= 5 && descTemporada != 0) {
                    DescuentoVolumen pedidoVolumen = new DescuentoVolumen(pedido);
                    totalCarrito -= Math.round(pedidoVolumen.getDescuento());
                    descVolumen = Math.round(pedidoVolumen.getDescuento());
                    totalProducto -= Math.round(pedidoVolumen.getDescuento());
                } else if (pedido.getCantidad() >= 5) {
                    DescuentoVolumen pedidoVolumen = new DescuentoVolumen(pedido);
                    totalCarrito += Math.round(pedidoVolumen.getPrecio());
                    descVolumen = Math.round(pedidoVolumen.getDescuento());
                    totalProducto = Math.round(pedidoVolumen.getPrecio());
                }

                if (descTemporada == 0 && descVolumen == 0) {
                    totalCarrito += Math.round(subtotal);
                    totalProducto = Math.round(subtotal);
                }

                subtotalCarrito += Math.round(subtotal);

                Map<String, Object> productoMap = new HashMap<>();
                productoMap.put("nombre", nombre);
                productoMap.put("precio", precio);
                productoMap.put("cantidad", cantidad);
                productoMap.put("subtotal", subtotal);
                productoMap.put("descVolumen", descVolumen);
                productoMap.put("descTemporada", descTemporada);
                productoMap.put("totalProducto", totalProducto);

                comprasAgrupadas.add(productoMap);
                detalle.setCantidadTotalProductos(compra.size());
                detalle.setMontoTotal(totalCarrito);
                detalle.setPesoTotal(pesoTotal);
            }

            sesion.setAttribute("detalle", detalle);
            model.addAttribute("compras", comprasAgrupadas);
            model.addAttribute("subtotalCarrito", subtotalCarrito);
            model.addAttribute("totalCarrito", totalCarrito);

        }
        return "carrito";
    }

    @PostMapping("/carrito/agregar")
    @ResponseBody
    public ResponseEntity<String> agregarProducto(@RequestBody Map<String, Object> datos, HttpSession sesion) {
        Integer idProducto = (Integer) datos.get("idProducto");
        Integer cantidad = (Integer) datos.get("cantidad");

        // Obtener el producto desde el servicio
        Producto producto = productoServicio.obtenerProductoPorId(idProducto);

        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado.");
        }

        // Verificar stock disponible
        if (cantidad > producto.getCantDisp()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Stock insuficiente. Disponible: " + producto.getCantDisp());
        }

        // Obtener la lista de productos en el carrito desde la sesión
        List<Producto> compra = (List<Producto>) sesion.getAttribute("compra");
        if (compra == null) {
            compra = new ArrayList<>();
        }

        // Agregar productos al carrito
        for (int i = 0; i < cantidad; i++) {
            compra.add(producto);
        }
        sesion.setAttribute("compra", compra);

        return ResponseEntity.ok("Producto agregado al carrito.");
    }

    @PostMapping("/carrito/eliminar")
    @ResponseBody
    public String eliminarProducto(@RequestBody Map<String, String> prod, HttpSession sesion) {
        String nombreProducto = prod.get("prod");
        List<Producto> compra = (List<Producto>) sesion.getAttribute("compra");
        if (compra != null) {
            compra = compra.stream()
                    .filter(producto -> !producto.getNombre().equals(nombreProducto))
                    .collect(Collectors.toList());
            sesion.setAttribute("compra", compra); // Actualizar la lista en la sesión
        }
        return "redirect:/carrito"; // Redirigir al carrito
    }

    @PostMapping("/carrito/verificar")
    public ResponseEntity<String> verificarCarrito(HttpSession sesion) {
        List<Producto> compra = (List<Producto>) sesion.getAttribute("compra");
        if (compra != null && compra.size() > 0) {
            return ResponseEntity.ok("");
        }
        return ResponseEntity.badRequest().body("");
    }
}