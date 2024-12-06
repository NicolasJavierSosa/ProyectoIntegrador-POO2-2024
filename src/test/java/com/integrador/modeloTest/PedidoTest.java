package com.integrador.modeloTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import modelo.*;


public class PedidoTest {

    private Pedido pedido;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testPedidoSettersAndGetters() {
        pedido.setEstado(EstadoPedido.ENTREGADO);
        pedido.setFechaCreacion(LocalDate.of(2023, 1, 1));

        Usuario usuario = new Usuario();
        usuario.setNombre("Nombre Test");
        pedido.setComprador(usuario);

        pedido.setDireccionEntrega("Calle Falsa 123");

        assertEquals(EstadoPedido.ENTREGADO, pedido.getEstado());
        assertEquals(LocalDate.of(2023, 1, 1), pedido.getFechaCreacion());
        assertEquals(usuario, pedido.getComprador());
        assertEquals("Calle Falsa 123", pedido.getDireccionEntrega());
    }

    @Test
    public void testValidacionesPedido() {
        // Estado nulo
        pedido.setEstado(null);
        Set<ConstraintViolation<Pedido>> violations = validator.validate(pedido);
        assertFalse(violations.isEmpty());

        // Fecha de creación nula
        pedido.setEstado(EstadoPedido.SIN_ENTREGAR);
        pedido.setFechaCreacion(null);
        violations = validator.validate(pedido);
        assertFalse(violations.isEmpty());

        // Comprador nulo
        pedido.setFechaCreacion(LocalDate.now());
        pedido.setComprador(null);
        violations = validator.validate(pedido);
        assertFalse(violations.isEmpty());

        // Dirección de entrega demasiado corta
        pedido.setComprador(new Usuario());
        pedido.setDireccionEntrega("Calle");
        violations = validator.validate(pedido);
        assertFalse(violations.isEmpty());

        // Atributos válidos
        pedido.setDireccionEntrega("Calle Falsa 123");
        violations = validator.validate(pedido);
        assertTrue(violations.isEmpty());
    }
}
