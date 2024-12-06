package com.integrador.proyecto.controller;

import java.util.HashMap;
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
import com.integrador.proyecto.servicio.DetallePedidoServicio;
import com.integrador.proyecto.servicio.PaqueteServicio;
import com.integrador.proyecto.servicio.PedidoServicio;
import com.integrador.proyecto.servicio.ProductoServicio;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import modelo.DetallePedido;
import modelo.Envio;
import modelo.EnvioLocal;
import modelo.EnvioNacional;
import modelo.EnvioProvincial;
import modelo.MercadoPago;
import modelo.Pago;
import modelo.Paquete;
import modelo.PaqueteProducto;
import modelo.Pedido;
import modelo.Producto;
import modelo.Tarjeta;
import modelo.TransferenciaBancaria;
import modelo.Usuario;

@Controller
@NoArgsConstructor
public class OrdenController {

    
    private PaqueteServicio servicePaq;
    private DetallePedidoServicio serviceDet;
    private PedidoServicio servicePed;
    private ProductoServicio serviceProd;

    @Autowired
    OrdenController(PaqueteServicio servicePaq, DetallePedidoServicio serviceDet, PedidoServicio servicePed, ProductoServicio serviceProd){
        this.servicePaq = servicePaq;
        this.serviceDet = serviceDet;
        this.servicePed = servicePed;
        this.serviceProd = serviceProd;
    }

    @GetMapping("/orden")
    public String mostrarOrden(HttpSession sesion, Model model) {
        
        
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
    


        if (usuario == null) {
            return "redirect:/sesion";
        }
        List<Producto> compra = (List<Producto>) sesion.getAttribute("compra");
        DetallePedido detalle = (DetallePedido) sesion.getAttribute("detalle");
        model.addAttribute("usuario", usuario);
        model.addAttribute("detalle", detalle);
        model.addAttribute("compra", compra);
    
        return "orden";
    }

    @PostMapping("/orden/realizar")
    @ResponseBody
    public ResponseEntity<String> realizarPedido(@RequestBody Map<String, String>infoPedido, HttpSession sesion, Model model) {
        
        List<Producto> compra = (List<Producto>) sesion.getAttribute("compra");
        DetallePedido detalle = (DetallePedido) sesion.getAttribute("detalle");

        String direccion = infoPedido.get("direccion");
        String ciudad = infoPedido.get("ciudad");
        String provincia = infoPedido.get("provincia");
        String metodoPago = infoPedido.get("metodoPago").toString();
        String metodoEnvio = infoPedido.get("metodoEnvio").toString();
        Pago pago;
        Envio envio;
        switch (metodoPago) {
            case "pago":
                pago = new MercadoPago();
                detalle.setMetodoPago(pago.procesarPago(detalle.getMontoTotal()));
                break;
        
            case "tarjeta":
                pago = new Tarjeta();
                detalle.setMetodoPago(pago.procesarPago(detalle.getMontoTotal()));
                break;
            
            case "transferencia":
                pago = new TransferenciaBancaria();
                detalle.setMetodoPago(pago.procesarPago(detalle.getMontoTotal()));
                break;

            default:
                throw new IllegalArgumentException("Metodo de pago invalido");
        }

        switch (metodoEnvio) {
            case "local":
                envio = new EnvioLocal();
                detalle.setMetodoEnvio(envio.tiempoEntrega());
                break;
        
            case "nacional":
                envio = new EnvioNacional();
                detalle.setMetodoEnvio(envio.tiempoEntrega());;
                break;
            
            case "provincial":
                envio = new EnvioProvincial();
                detalle.setMetodoEnvio(envio.tiempoEntrega());;
                break;

            default:
                throw new IllegalArgumentException("Metodo de envio invalido");
        }
        
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");

        Map<String, Integer> contadorProductos = new HashMap<>();
        Paquete paquete = new Paquete();
        Pedido pedido = new Pedido();
        
    
        // Iterar sobre la lista de productos y contar las cantidades por tipo
        for (Producto producto : compra) {
            String tipoProducto = producto.getNombre(); // Asumiendo que "getNombre" te da el tipo de producto (como "tomate", "cebolla", etc.)
        
            // Si el producto ya está en el mapa, incrementa el contador
            if (contadorProductos.containsKey(tipoProducto)) {
                contadorProductos.put(tipoProducto, contadorProductos.get(tipoProducto) + 1);
                int i = 0;
                while(i < paquete.getElementosPaquete().size() && producto != paquete.getElementosPaquete().get(i).getProducto()){
                    i++;
                }
                if(producto == paquete.getElementosPaquete().get(i).getProducto()){
                    paquete.getElementosPaquete().get(i).setCantidadDeProducto(contadorProductos.get(tipoProducto));
                }
            } else {
                // Si no está, agrega el producto con un contador inicial de 1
                contadorProductos.put(tipoProducto, 1);
                PaqueteProducto pp = new PaqueteProducto();
                pp.setProducto(producto);
                pp.setPaquete(paquete);
                pp.setCantidadDeProducto(1);
                paquete.getElementosPaquete().add(pp);
            }
        }
        
        detalle.setProductosComprados(paquete);
        pedido.setComprador(usuario);

        pedido.setDireccionEntrega("El pedido se debe entregar en: " + direccion);
        if(!ciudad.isBlank()){
            pedido.setDireccionEntrega(pedido.getDireccionEntrega() + ", en la ciudad: " + ciudad);
        }
        if(!provincia.isBlank()){
            pedido.setDireccionEntrega(pedido.getDireccionEntrega() + ", en la provincia: " + provincia);
        }
        for(int i = 0; i < paquete.getElementosPaquete().size(); i++){
            Producto p = paquete.getElementosPaquete().get(i).getProducto();
            serviceProd.guardarProducto(p);
        }

        
        servicePaq.guardarPaquete(paquete);
        servicePed.guardarPedido(pedido);
        serviceDet.guardarDetalle(detalle);

        sesion.removeAttribute("compra");
        sesion.removeAttribute("detalle");

        return ResponseEntity.ok("");
    }
    
}
