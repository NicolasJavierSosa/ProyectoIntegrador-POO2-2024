package com.integrador.controladorTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.integrador.proyecto.controller.OrdenController;
import com.integrador.proyecto.servicio.PaqueteServicio;
import com.integrador.proyecto.servicio.DetallePedidoServicio;
import com.integrador.proyecto.servicio.PedidoServicio;
import com.integrador.proyecto.servicio.ProductoServicio;
import modelo.Producto;
import modelo.DetallePedido;
import modelo.Pedido;
import modelo.Usuario;

@SpringBootTest(classes = com.integrador.proyecto.ProyectoIntegradorPoo2Application.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@Transactional
public class OrdenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PaqueteServicio paqueteServicio;

    @Mock
    private DetallePedidoServicio detallePedidoServicio;

    @Mock
    private PedidoServicio pedidoServicio;

    @Mock
    private ProductoServicio productoServicio;

    @InjectMocks
    private OrdenController ordenController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testMostrarOrden() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario Test");

        DetallePedido detalle = new DetallePedido();
        detalle.setMontoTotal(1000.0);

        Producto producto = new Producto();
        producto.setNombre("Producto 1");
        producto.setPrecio(1000);

        List<Producto> compra = new ArrayList<>();
        compra.add(producto);

        mockMvc.perform(get("/orden")
                .sessionAttr("usuario", usuario)
                .sessionAttr("compra", compra)
                .sessionAttr("detalle", detalle))
            .andExpect(status().isOk())
            .andExpect(view().name("orden"))
            .andExpect(model().attributeExists("usuario"))
            .andExpect(model().attributeExists("detalle"))
            .andExpect(model().attributeExists("compra"));
    }

    @Test
    public void testRealizarPedido() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario Test");

        DetallePedido detalle = new DetallePedido();
        detalle.setMontoTotal(1000.0);

        Producto producto = new Producto();
        producto.setNombre("Producto 1");
        producto.setPrecio(1000);
        producto.setCantDisp(10);

        List<Producto> compra = new ArrayList<>();
        compra.add(producto);

        Map<String, String> infoPedido = new HashMap<>();
        infoPedido.put("direccion", "Direccion Test");
        infoPedido.put("ciudad", "Ciudad Test");
        infoPedido.put("provincia", "Provincia Test");
        infoPedido.put("metodoPago", "tarjeta");
        infoPedido.put("metodoEnvio", "local");

        // Usar doAnswer para manejar void método
        Mockito.doAnswer(invocation -> {
            Pedido pedido = invocation.getArgument(0);
            pedido.setComprador(usuario);
            return null;
        }).when(pedidoServicio).guardarPedido(Mockito.any(Pedido.class));

        Mockito.when(productoServicio.obtenerProductoPorId(1)).thenReturn(producto);

        mockMvc.perform(post("/orden/realizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"direccion\": \"Direccion Test\", \"ciudad\": \"Ciudad Test\", \"provincia\": \"Provincia Test\", \"metodoPago\": \"tarjeta\", \"metodoEnvio\": \"local\" }")
                .sessionAttr("usuario", usuario)
                .sessionAttr("compra", compra)
                .sessionAttr("detalle", detalle))
            .andExpect(status().isOk());
    }
}
