package com.integrador.controladorTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;

import com.integrador.proyecto.controller.CarritoController;
import modelo.Usuario;

@SpringBootTest(classes = com.integrador.proyecto.ProyectoIntegradorPoo2Application.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class CarritoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HttpSession sesion;

    @InjectMocks
    private CarritoController carritoController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testInicio() throws Exception {
        mockMvc.perform(get("/carrito")
                .sessionAttr("usuario", new Usuario()))
                .andExpect(status().isOk())
                .andExpect(view().name("carrito"));

        // Verifica que el modelo tiene los atributos esperados solo si existen compras
        mockMvc.perform(get("/carrito")
                .sessionAttr("usuario", new Usuario())
                .sessionAttr("compra", new ArrayList<>()))
                .andExpect(status().isOk())
                .andExpect(view().name("carrito"))
                .andExpect(model().attributeExists("compras"))
                .andExpect(model().attributeExists("subtotalCarrito"))
                .andExpect(model().attributeExists("totalCarrito"));
    }

    @Test
    public void testEliminarProducto() throws Exception {
        Map<String, String> prod = new HashMap<>();
        prod.put("prod", "ProductoTest");

        mockMvc.perform(post("/carrito/eliminar")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"prod\": \"ProductoTest\"}"))
                .andExpect(status().is3xxRedirection())  // Verifica redirección
                .andExpect(view().name("redirect:/carrito"));
    }

    @Test
    public void testVerificarCarrito() throws Exception {
        mockMvc.perform(post("/carrito/verificar")
                .sessionAttr("compra", new ArrayList<>()))
                .andExpect(status().isBadRequest());
    }
}
