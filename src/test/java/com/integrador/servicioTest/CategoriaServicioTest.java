package com.integrador.servicioTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.integrador.proyecto.repositorio.CategoriaRepositorio;
import com.integrador.proyecto.servicio.CategoriaServicio;
import modelo.Categoria;
import modelo.Producto;

@ExtendWith(MockitoExtension.class)
public class CategoriaServicioTest {

    @Mock
    private CategoriaRepositorio categoriaRepositorio;

    @InjectMocks
    private CategoriaServicio categoriaServicio;

    private Categoria categoria;
    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    public void setUp() {
        producto1 = new Producto();
        // Inicializa el objeto Producto según sea necesario
        producto2 = new Producto();
        // Inicializa el objeto Producto según sea necesario

        Set<Producto> productos = new HashSet<>(Arrays.asList(producto1, producto2));

        categoria = new Categoria(productos);
        // Inicializa otros atributos de Categoria según sea necesario
    }

    @Test
    public void testObtenerTodasCategorias() {
        List<Categoria> categorias = Arrays.asList(categoria);
        when(categoriaRepositorio.findAll()).thenReturn(categorias);

        List<Categoria> resultado = categoriaServicio.obtenerTodasCategorias();

        assert(resultado.size() == 1);
        verify(categoriaRepositorio).findAll();
    }

    @Test
    public void testObtenerProductosPorCategoria() {
        when(categoriaRepositorio.findById(1)).thenReturn(Optional.of(categoria));

        List<Producto> productos = categoriaServicio.obtenerProductosPorCategoria(1);

        assert(productos.size() == 2);
        verify(categoriaRepositorio).findById(1);
    }
}
