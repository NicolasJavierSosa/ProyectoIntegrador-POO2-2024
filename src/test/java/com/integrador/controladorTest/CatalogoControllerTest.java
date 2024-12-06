package com.integrador.controladorTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

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

import com.integrador.proyecto.controller.CatalogoController;
import com.integrador.proyecto.servicio.CategoriaServicio;
import com.integrador.proyecto.servicio.ProductoServicio;
import modelo.Categoria;
import modelo.Producto;

@SpringBootTest(classes = com.integrador.proyecto.ProyectoIntegradorPoo2Application.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class CatalogoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductoServicio productoServicio;

    @Mock
    private CategoriaServicio categoriaServicio;

    @InjectMocks
    private CatalogoController catalogoController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testMostrarCatalogo() throws Exception {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setPrecio(100);

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setPrecio(200);

        Categoria categoria1 = new Categoria();
        categoria1.setNombreCategoria("Categoria 1");

        Mockito.when(productoServicio.obtenerTodosProductos()).thenReturn(Arrays.asList(producto1, producto2));
        Mockito.when(categoriaServicio.obtenerTodasCategorias()).thenReturn(Arrays.asList(categoria1));

        mockMvc.perform(get("/catalogo"))
            .andExpect(status().isOk())
            .andExpect(view().name("catalogo"))
            .andExpect(model().attributeExists("productos"))
            .andExpect(model().attributeExists("categorias"));
    }

    @Test
    public void testBuscarPorNombre() throws Exception {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");

        Mockito.when(productoServicio.buscarPorNombre("Producto 1")).thenReturn(Arrays.asList(producto1));
        Mockito.when(categoriaServicio.obtenerTodasCategorias()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/catalogo")
                .param("buscar", "Producto 1"))
            .andExpect(status().isOk())
            .andExpect(view().name("catalogo"))
            .andExpect(model().attributeExists("productos"))
            .andExpect(model().attributeExists("categorias"));
    }

    @Test
    public void testOrdenarPorPrecioAsc() throws Exception {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setPrecio(100);

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setPrecio(200);

        Mockito.when(productoServicio.ordenarPorPrecioAsc()).thenReturn(Arrays.asList(producto1, producto2));
        Mockito.when(categoriaServicio.obtenerTodasCategorias()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/catalogo")
                .param("ordenar", "menor-precio"))
            .andExpect(status().isOk())
            .andExpect(view().name("catalogo"))
            .andExpect(model().attributeExists("productos"))
            .andExpect(model().attributeExists("categorias"));
    }

    @Test
    public void testOrdenarPorPrecioDesc() throws Exception {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setPrecio(100);

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setPrecio(200);

        Mockito.when(productoServicio.ordenarPorPrecioDesc()).thenReturn(Arrays.asList(producto1, producto2));
        Mockito.when(categoriaServicio.obtenerTodasCategorias()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/catalogo")
                .param("ordenar", "mayor-precio"))
            .andExpect(status().isOk())
            .andExpect(view().name("catalogo"))
            .andExpect(model().attributeExists("productos"))
            .andExpect(model().attributeExists("categorias"));
    }

    @Test
    public void testBuscarPorCategoria() throws Exception {
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");

        Mockito.when(productoServicio.buscarPorCategoria("Categoria 1")).thenReturn(Arrays.asList(producto1));
        Mockito.when(categoriaServicio.obtenerTodasCategorias()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/catalogo")
                .param("categoria", "Categoria 1"))
            .andExpect(status().isOk())
            .andExpect(view().name("catalogo"))
            .andExpect(model().attributeExists("productos"))
            .andExpect(model().attributeExists("categorias"));
    }
}
