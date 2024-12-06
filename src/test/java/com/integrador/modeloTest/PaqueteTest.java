package com.integrador.modeloTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Paquete;
import modelo.Producto;
import modelo.PaqueteProducto;

public class PaqueteTest {

    private Paquete paquete;

    @BeforeEach
    public void setUp() {
        paquete = new Paquete();
    }

    @Test
    public void testGetPrecio() {
        // Crear productos de prueba y añadirlos al paquete
        Producto producto1 = new Producto();
        producto1.setPrecio(100.0);

        Producto producto2 = new Producto();
        producto2.setPrecio(200.0);

        PaqueteProducto pp1 = new PaqueteProducto();
        pp1.setProducto(producto1);
        pp1.setPaquete(paquete);

        PaqueteProducto pp2 = new PaqueteProducto();
        pp2.setProducto(producto2);
        pp2.setPaquete(paquete);

        List<PaqueteProducto> elementosPaquete = new ArrayList<>();
        elementosPaquete.add(pp1);
        elementosPaquete.add(pp2);

        paquete.setElementosPaquete(elementosPaquete);

        // Verificar el precio total del paquete
        double precioTotal = paquete.getPrecio();
        assertEquals(300.0, precioTotal);
    }

    @Test
    public void testGetPeso() {
        // Crear productos de prueba y añadirlos al paquete
        Producto producto1 = new Producto();
        producto1.setPeso(1.0);

        Producto producto2 = new Producto();
        producto2.setPeso(2.0);

        PaqueteProducto pp1 = new PaqueteProducto();
        pp1.setProducto(producto1);
        pp1.setPaquete(paquete);

        PaqueteProducto pp2 = new PaqueteProducto();
        pp2.setProducto(producto2);
        pp2.setPaquete(paquete);

        List<PaqueteProducto> elementosPaquete = new ArrayList<>();
        elementosPaquete.add(pp1);
        elementosPaquete.add(pp2);

        paquete.setElementosPaquete(elementosPaquete);

        // Verificar el peso total del paquete
        double pesoTotal = paquete.getPeso();
        assertEquals(3.0, pesoTotal);
    }

    @Test
    public void testAgregarElementoPaquete() {
        Producto producto = new Producto();
        producto.setPrecio(100.0);
        producto.setPeso(1.0);

        PaqueteProducto pp = new PaqueteProducto();
        pp.setProducto(producto);
        pp.setPaquete(paquete);

        paquete.getElementosPaquete().add(pp);

        assertEquals(1, paquete.getElementosPaquete().size());
        assertEquals(pp, paquete.getElementosPaquete().get(0));
    }
}
