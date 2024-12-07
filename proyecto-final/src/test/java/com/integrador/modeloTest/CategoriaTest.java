package com.integrador.modeloTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import modelo.Categoria;
import modelo.Producto;

public class CategoriaTest {

    private Categoria categoria;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria(new HashSet<>());
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testCategoriaSettersAndGetters() {
        categoria.setNombreCategoria("Categoria Test");
        categoria.setDescripcionCategoria("Descripción de la categoría de prueba");
        categoria.setImgCategoria("imagen.jpg");

        assertEquals("Categoria Test", categoria.getNombreCategoria());
        assertEquals("Descripción de la categoría de prueba", categoria.getDescripcionCategoria());
        assertEquals("imagen.jpg", categoria.getImgCategoria());
    }

    @Test
    public void testProductos() {
        Set<Producto> productos = new HashSet<>();
        Producto producto = new Producto();
        producto.setNombre("Producto Test");

        productos.add(producto);
        categoria.setProductos(productos);

        assertNotNull(categoria.getProductos());
        assertEquals(1, categoria.getProductos().size());
        assertTrue(categoria.getProductos().contains(producto));
    }

    @Test
    public void testValidacionesCategoria() {
        // Nombre de categoría muy corto
        categoria.setNombreCategoria("Cat");
        Set<ConstraintViolation<Categoria>> violations = validator.validate(categoria);
        assertFalse(violations.isEmpty());

        // Descripción de categoría muy corta
        categoria.setNombreCategoria("Categoria Test");
        categoria.setDescripcionCategoria("Descripción corta");
        violations = validator.validate(categoria);
        assertFalse(violations.isEmpty());

        // Imagen en blanco
        categoria.setDescripcionCategoria("Descripción de la categoría de prueba");
        categoria.setImgCategoria("");
        violations = validator.validate(categoria);
        assertFalse(violations.isEmpty());

        // Atributos válidos
        categoria.setImgCategoria("imagen.jpg");
        violations = validator.validate(categoria);
        assertTrue(violations.isEmpty());
    }
}
