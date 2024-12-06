package com.integrador.controladorTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.integrador.proyecto.controller.ProductoController;
import com.integrador.proyecto.servicio.ProductoServicio;
import modelo.Producto;
import modelo.Usuario;

@SpringBootTest(classes = com.integrador.proyecto.ProyectoIntegradorPoo2Application.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductoServicio productoServicio;

    @InjectMocks
    private ProductoController productoController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testMostrarProducto() throws Exception {
        Producto producto = new Producto();
        producto.setNombre("Producto 1");
        producto.setPrecio(1000);

        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario Test");

        Mockito.when(productoServicio.obtenerProductoPorId(1)).thenReturn(producto);

        mockMvc.perform(get("/productos/producto/1")
                .sessionAttr("usuario", usuario))
            .andExpect(status().isOk())
            .andExpect(view().name("producto"))
            .andExpect(model().attributeExists("producto"))
            .andExpect(model().attributeExists("usuario"));
    }

    @Test
    public void testMostrarProductoSinUsuario() throws Exception {
        Producto producto = new Producto();
        producto.setNombre("Producto 1");
        producto.setPrecio(1000);

        Mockito.when(productoServicio.obtenerProductoPorId(1)).thenReturn(producto);

        mockMvc.perform(get("/productos/producto/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("producto"))
            .andExpect(model().attributeExists("producto"));
    }

    @Test
    public void testMostrarCatalogo() throws Exception {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setPrecio(1000);

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setPrecio(2000);

        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario Test");

        List<Producto> productos = Arrays.asList(producto1, producto2);

        Mockito.when(productoServicio.obtenerProductos()).thenReturn(productos);

        mockMvc.perform(get("/productos/catalogo")
                .sessionAttr("usuario", usuario))
            .andExpect(status().isOk())
            .andExpect(view().name("catalogo"))
            .andExpect(model().attributeExists("productos"))
            .andExpect(model().attributeExists("usuario"));
    }

    @Test
    public void testMostrarCatalogoSinUsuario() throws Exception {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setPrecio(1000);

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setPrecio(2000);

        List<Producto> productos = Arrays.asList(producto1, producto2);

        Mockito.when(productoServicio.obtenerProductos()).thenReturn(productos);

        mockMvc.perform(get("/productos/catalogo"))
            .andExpect(status().isOk())
            .andExpect(view().name("catalogo"))
            .andExpect(model().attributeExists("productos"));
    }
}
