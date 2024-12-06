package com.integrador.servicioTest;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.integrador.proyecto.repositorio.UsuarioRepositorio;
import com.integrador.proyecto.servicio.UsuarioServicio;

import modelo.Usuario;

@ExtendWith(MockitoExtension.class)
public class UsuarioServicioTest {

    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    @InjectMocks
    private UsuarioServicio usuarioServicio;

    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    public void setUp() {
        usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setCorreo("usuario1@example.com");
        usuario1.setPassword("password1");

        usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setCorreo("usuario2@example.com");
        usuario2.setPassword("password2");
    }

    @Test
    public void testListarTodos() {
        when(usuarioRepositorio.findAll()).thenReturn(Arrays.asList(usuario1, usuario2));

        List<Usuario> usuarios = usuarioServicio.listarTodos();

        assert(usuarios.size() == 2);
        assert(usuarios.get(0).getCorreo().equals("usuario1@example.com"));
        assert(usuarios.get(1).getCorreo().equals("usuario2@example.com"));
    }

    @Test
    public void testGuardar() {
        when(usuarioRepositorio.save(usuario1)).thenReturn(usuario1);

        Usuario usuario = usuarioServicio.guardar(usuario1);

        assert(usuario != null);
        assert(usuario.getCorreo().equals("usuario1@example.com"));
    }

    @Test
    public void testObtenerPorId() {
        when(usuarioRepositorio.findById(1L)).thenReturn(Optional.of(usuario1));

        Optional<Usuario> usuario = usuarioServicio.obtenerPorId(1L);

        assert(usuario.isPresent());
        assert(usuario.get().getCorreo().equals("usuario1@example.com"));
    }

    @Test
    public void testEliminar() {
        usuarioServicio.eliminar(1L);

        verify(usuarioRepositorio, times(1)).deleteById(1L);
    }

    @Test
    public void testAutenticar() throws Exception {
        when(usuarioRepositorio.findByCorreo("usuario1@example.com")).thenReturn(Optional.of(usuario1));

        Usuario usuario = usuarioServicio.autenticar("usuario1@example.com", "password1");

        assert(usuario != null);
        assert(usuario.getCorreo().equals("usuario1@example.com"));
    }

    @Test
    public void testAutenticarConContraseñaIncorrecta() {
        when(usuarioRepositorio.findByCorreo("usuario1@example.com")).thenReturn(Optional.of(usuario1));

        try {
            usuarioServicio.autenticar("usuario1@example.com", "wrongpassword");
        } catch (Exception e) {
            assert(e.getMessage().equals("Contraseña incorrecta"));
        }
    }
}
