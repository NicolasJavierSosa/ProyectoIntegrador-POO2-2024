package com.integrador.servicioTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.integrador.proyecto.repositorio.PedidoRepositorio;
import com.integrador.proyecto.servicio.PedidoServicio;
import modelo.Pedido;

@ExtendWith(MockitoExtension.class)
public class PedidoServicioTest {

    @Mock
    private PedidoRepositorio pedidoRepositorio;

    @InjectMocks
    private PedidoServicio pedidoServicio;

    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        // Inicializa el objeto Pedido según sea necesario
    }

    @Test
    public void testGuardarPedido() {
        pedidoServicio.guardarPedido(pedido);

        verify(pedidoRepositorio, times(1)).save(pedido);
    }
}
