package com.integrador.modeloTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import modelo.PedidoBase;

public class PedidoBaseTest {

    private PedidoBase pedidoBase;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        pedidoBase = new PedidoBase();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testPedidoBaseSettersAndGetters() {
        pedidoBase.setCantidad(5);
        pedidoBase.setSubtotal(1000.0);
        pedidoBase.setPesoSubtotal(15.0);

        assertEquals(5, pedidoBase.getCantidad());
        assertEquals(1000.0, pedidoBase.getPrecio());
        assertEquals(15.0, pedidoBase.getPeso());
    }

    @Test
    public void testValidacionesPedidoBase() {
        // Cantidad nula
        pedidoBase.setCantidad(0);
        Set<ConstraintViolation<PedidoBase>> violations = validator.validate(pedidoBase);
        assertFalse(violations.isEmpty());

        // Subtotal nulo
        pedidoBase.setCantidad(5);
        pedidoBase.setSubtotal(null);
        violations = validator.validate(pedidoBase);
        assertFalse(violations.isEmpty());

        // Peso subtotal nulo
        pedidoBase.setSubtotal(1000.0);
        pedidoBase.setPesoSubtotal(null);
        violations = validator.validate(pedidoBase);
        assertFalse(violations.isEmpty());

        // Atributos válidos
        pedidoBase.setPesoSubtotal(15.0);
        violations = validator.validate(pedidoBase);
        assertTrue(violations.isEmpty());
    }
}
