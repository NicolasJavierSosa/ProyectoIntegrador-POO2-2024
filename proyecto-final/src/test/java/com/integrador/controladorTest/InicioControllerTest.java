package com.integrador.controladorTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

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

import com.integrador.proyecto.controller.InicioController;
import com.integrador.proyecto.servicio.ProductoServicio;
import com.integrador.proyecto.servicio.CategoriaServicio;
import modelo.Producto;
import modelo.Categoria;

@SpringBootTest(classes = com.integrador.proyecto.ProyectoIntegradorPoo2Application.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class InicioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductoServicio productoServicio;

    @Mock
    private CategoriaServicio categoriaServicio;

    @InjectMocks
    private InicioController inicioController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testInicio() throws Exception {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setPrecio(1000);

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setPrecio(2000);

        Producto producto3 = new Producto();
        producto3.setNombre("Producto 3");
        producto3.setPrecio(3000);

        Categoria categoria1 = new Categoria();
        categoria1.setNombreCategoria("Categoria 1");

        List<Producto> productos = Arrays.asList(producto1, producto2, producto3);
        List<Categoria> categorias = Arrays.asList(categoria1);

        Mockito.when(productoServicio.obtenerProductos()).thenReturn(productos);
        Mockito.when(categoriaServicio.obtenerTodasCategorias()).thenReturn(categorias);

        mockMvc.perform(get("/inicio"))
            .andExpect(status().isOk())
            .andExpect(view().name("inicio"))
            .andExpect(model().attributeExists("categorias"))
            .andExpect(model().attributeExists("productosDes"));
    }

    @Test
    public void testAgregarProductoAlCarrito() throws Exception {
        Producto producto = new Producto();
        producto.setNombre("Producto 1");
        producto.setPrecio(1000);
        producto.setCantDisp(10);

        Mockito.when(productoServicio.obtenerProductoPorId(1)).thenReturn(producto);

        Map<String, Integer> datos = new HashMap<>();
        datos.put("idProducto", 1);
        datos.put("cantidad", 2);

        mockMvc.perform(post("/inicio/agregar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"idProducto\": 1, \"cantidad\": 2}")
                .sessionAttr("compra", new ArrayList<Producto>()))
            .andExpect(status().isOk());
    }
}
