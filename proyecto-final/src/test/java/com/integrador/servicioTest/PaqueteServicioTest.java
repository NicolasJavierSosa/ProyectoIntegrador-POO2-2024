package com.integrador.servicioTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.integrador.proyecto.repositorio.PaqueteRepositorio;
import com.integrador.proyecto.servicio.PaqueteServicio;
import modelo.Paquete;

@ExtendWith(MockitoExtension.class)
public class PaqueteServicioTest {

    @Mock
    private PaqueteRepositorio paqueteRepositorio;

    @InjectMocks
    private PaqueteServicio paqueteServicio;

    private Paquete paquete1;
    private Paquete paquete2;

    @BeforeEach
    public void setUp() {
        paquete1 = new Paquete();
        // Inicializa el objeto Paquete según sea necesario
        paquete2 = new Paquete();
        // Inicializa el objeto Paquete según sea necesario
    }

    @Test
    public void testGuardarPaquete() {
        paqueteServicio.guardarPaquete(paquete1);

        verify(paqueteRepositorio, times(1)).save(paquete1);
    }

    @Test
    public void testBuscarPaquetes() {
        when(paqueteRepositorio.findAll()).thenReturn(Arrays.asList(paquete1, paquete2));

        List<Paquete> paquetes = paqueteServicio.buscarPaquetes();

        assert(paquetes.size() == 2);
    }

    @Test
    public void testEliminarPaquete() {
        Integer idPaquete = 1;
        paqueteServicio.eliminarPaquete(idPaquete);

        verify(paqueteRepositorio, times(1)).deleteById(idPaquete);
    }
}
