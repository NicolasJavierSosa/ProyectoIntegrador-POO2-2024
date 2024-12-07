package com.integrador.modeloTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import modelo.*;

public class DetallePedidoTest {

    private DetallePedido detallePedido;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        detallePedido = new DetallePedido();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testDetallePedidoSettersAndGetters() {
        Paquete paquete = new Paquete();
        detallePedido.setCantidadTotalProductos(5);
        detallePedido.setMontoTotal(1000.0);
        detallePedido.setPesoTotal(15.0);
        detallePedido.setProductosComprados(paquete);
        detallePedido.setMetodoPago("Tarjeta");
        detallePedido.setMetodoEnvio("Local");

        assertEquals(5, detallePedido.getCantidadTotalProductos());
        assertEquals(1000.0, detallePedido.getMontoTotal());
        assertEquals(15.0, detallePedido.getPesoTotal());
        assertEquals(paquete, detallePedido.getProductosComprados());
        assertEquals("Tarjeta", detallePedido.getMetodoPago());
        assertEquals("Local", detallePedido.getMetodoEnvio());
    }

    @Test
    public void testValidacionesDetallePedido() {
        // Cantidad total de productos nula
        detallePedido.setCantidadTotalProductos(0);
        Set<ConstraintViolation<DetallePedido>> violations = validator.validate(detallePedido);
        assertFalse(violations.isEmpty());

        // Monto total nulo
        detallePedido.setCantidadTotalProductos(5);
        detallePedido.setMontoTotal(null);
        violations = validator.validate(detallePedido);
        assertFalse(violations.isEmpty());

        // Peso total nulo
        detallePedido.setMontoTotal(1000.0);
        detallePedido.setPesoTotal(null);
        violations = validator.validate(detallePedido);
        assertFalse(violations.isEmpty());

        // Productos comprados nulos
        detallePedido.setPesoTotal(15.0);
        detallePedido.setProductosComprados(null);
        violations = validator.validate(detallePedido);
        assertFalse(violations.isEmpty());

        // Método de pago nulo
        detallePedido.setProductosComprados(new Paquete());
        detallePedido.setMetodoPago(null);
        violations = validator.validate(detallePedido);
        assertFalse(violations.isEmpty());

        // Método de envío nulo
        detallePedido.setMetodoPago("Tarjeta");
        detallePedido.setMetodoEnvio(null);
        violations = validator.validate(detallePedido);
        assertFalse(violations.isEmpty());

        // Atributos válidos
        detallePedido.setMetodoEnvio("Local");
        violations = validator.validate(detallePedido);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testVaciar() {
        detallePedido.setCantidadTotalProductos(5);
        detallePedido.setMontoTotal(1000.0);
        detallePedido.setPesoTotal(15.0);

        detallePedido.vaciar();

        assertEquals(0, detallePedido.getCantidadTotalProductos());
        assertEquals(0.0, detallePedido.getMontoTotal());
        assertEquals(0.0, detallePedido.getPesoTotal());
    }
}
