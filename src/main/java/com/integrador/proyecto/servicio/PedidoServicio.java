package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.proyecto.repositorio.PedidoRepositorio;
import modelo.Pedido;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio repository;

    @Autowired
    PedidoServicio(PedidoRepositorio repository){
        this.repository = repository;
    }

    public void guardarPedido(Pedido pedido){
        repository.save(pedido);
    }

}
