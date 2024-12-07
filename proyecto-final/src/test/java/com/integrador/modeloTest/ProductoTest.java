package com.integrador.modeloTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
import modelo.Producto;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    private Producto producto;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        producto = new Producto();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testProductoSettersAndGetters() {
        producto.setNombre("Producto Test");
        producto.setDescripcion("Descripción del producto de prueba");
        producto.setPrecio(200.50);
        producto.setPeso(1.5);
        producto.setImgProducto("imagen.jpg");
        producto.setCantDisp(10);

        assertEquals("Producto Test", producto.getNombre());
        assertEquals("Descripción del producto de prueba", producto.getDescripcion());
        assertEquals(200.50, producto.getPrecio());
        assertEquals(1.5, producto.getPeso());
        assertEquals("imagen.jpg", producto.getImgProducto());
        assertEquals(10, producto.getCantDisp());
    }

    @Test
    public void testValidacionesProducto() {
        // Nombre muy corto
        producto.setNombre("Prod");
        Set<ConstraintViolation<Producto>> violations = validator.validate(producto);
        assertFalse(violations.isEmpty());

        // Descripción muy larga
        producto.setNombre("Producto Test");
        producto.setDescripcion("Descripción".repeat(20));
        violations = validator.validate(producto);
        assertFalse(violations.isEmpty());

        // Precio negativo
        producto.setDescripcion("Descripción del producto de prueba");
        producto.setPrecio(-10.0);
        violations = validator.validate(producto);
        assertFalse(violations.isEmpty());

        // Peso negativo
        producto.setPrecio(200.50);
        producto.setPeso(-1.5);
        violations = validator.validate(producto);
        assertFalse(violations.isEmpty());

        // Imagen en blanco
        producto.setPeso(1.5);
        producto.setImgProducto("");
        violations = validator.validate(producto);
        assertFalse(violations.isEmpty());

        // Cantidad disponible negativa
        producto.setImgProducto("imagen.jpg");
        producto.setCantDisp(-5);
        violations = validator.validate(producto);
        assertFalse(violations.isEmpty());

        // Atributos válidos
        producto.setCantDisp(10);
        violations = validator.validate(producto);
        assertTrue(violations.isEmpty());
    }
}
