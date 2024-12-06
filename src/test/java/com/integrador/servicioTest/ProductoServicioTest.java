package com.integrador.servicioTest;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.integrador.proyecto.repositorio.ProductoRepositorio;
import com.integrador.proyecto.servicio.ProductoServicio;
import modelo.Producto;

@ExtendWith(MockitoExtension.class)
public class ProductoServicioTest {

    @Mock
    private ProductoRepositorio productoRepository;

    @InjectMocks
    private ProductoServicio productoServicio;

    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    public void setUp() {
        producto1 = new Producto();
        producto1.setNombre("Producto 1");

        producto2 = new Producto();
        producto2.setNombre("Producto 2");
    }

    @Test
    public void testObtenerTodosProductos() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(producto1, producto2));

        List<Producto> productos = productoServicio.obtenerTodosProductos();

        assert(productos.size() == 2);
        assert(productos.get(0).getNombre().equals("Producto 1"));
        assert(productos.get(1).getNombre().equals("Producto 2"));
    }

    @Test
    public void testObtenerProductoPorId() {
        when(productoRepository.findById(1)).thenReturn(Optional.of(producto1));

        Producto producto = productoServicio.obtenerProductoPorId(1);

        assert(producto != null);
        assert(producto.getNombre().equals("Producto 1"));
    }

    @Test
    public void testBuscarPorNombre() {
        when(productoRepository.findByNombreContainingIgnoreCase("Producto")).thenReturn(Arrays.asList(producto1, producto2));

        List<Producto> productos = productoServicio.buscarPorNombre("Producto");

        assert(productos.size() == 2);
        assert(productos.get(0).getNombre().equals("Producto 1"));
        assert(productos.get(1).getNombre().equals("Producto 2"));
    }

    @Test
    public void testGuardarProducto() {
        productoServicio.guardarProducto(producto1);

        verify(productoRepository, times(1)).save(producto1);
    }

    @Test
    public void testEliminarProducto() {
        productoServicio.eliminarProducto(1);

        verify(productoRepository, times(1)).deleteById(1);
    }
}
