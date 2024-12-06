package com.integrador.modeloTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;
import modelo.Usuario;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testUsuarioSettersAndGetters() {
        usuario.setUsername("usuarioTest");
        usuario.setPassword("contraseñaSegura");
        usuario.setNombre("Nombre");
        usuario.setApellido("Apellido");
        usuario.setCorreo("correo@example.com");

        assertEquals("usuarioTest", usuario.getUsername());
        assertEquals("contraseñaSegura", usuario.getPassword());
        assertEquals("Nombre", usuario.getNombre());
        assertEquals("Apellido", usuario.getApellido());
        assertEquals("correo@example.com", usuario.getCorreo());
    }

    @Test
    public void testNombreCompleto() {
        usuario.setNombre("Nombre");
        usuario.setApellido("Apellido");

        assertEquals("Nombre Apellido", usuario.nombreCompleto());
    }

    @Test
    public void testValidacionesUsuario() {
        // Username muy corto
        usuario.setUsername("");
        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        assertFalse(violations.isEmpty());

        // Password en blanco
        usuario.setUsername("usuarioTest");
        usuario.setPassword("");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty());

        // Nombre en blanco
        usuario.setPassword("contraseñaSegura");
        usuario.setNombre("");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty());

        // Apellido en blanco
        usuario.setNombre("Nombre");
        usuario.setApellido("");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty());

        // Correo inválido
        usuario.setApellido("Apellido");
        usuario.setCorreo("correo_invalido");
        violations = validator.validate(usuario);
        assertFalse(violations.isEmpty());

        // Atributos válidos
        usuario.setCorreo("correo@example.com");
        violations = validator.validate(usuario);
        assertTrue(violations.isEmpty());
    }
}
