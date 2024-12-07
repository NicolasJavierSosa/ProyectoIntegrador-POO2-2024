package com.integrador.servicioTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.integrador.proyecto.repositorio.DetallePedidoRepositorio;
import com.integrador.proyecto.servicio.DetallePedidoServicio;
import modelo.DetallePedido;

@ExtendWith(MockitoExtension.class)
public class DetallePedidoServicioTest {

    @Mock
    private DetallePedidoRepositorio detallePedidoRepositorio;

    @InjectMocks
    private DetallePedidoServicio detallePedidoServicio;

    private DetallePedido detallePedido;

    @BeforeEach
    public void setUp() {
        detallePedido = new DetallePedido();
        // Inicializa el objeto DetallePedido según sea necesario
    }

    @Test
    public void testGuardarDetalle() {
        detallePedidoServicio.guardarDetalle(detallePedido);

        verify(detallePedidoRepositorio, times(1)).save(detallePedido);
    }
}
