package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.proyecto.repositorio.PedidoRepositorio;

@Service
public class PedidoServicio {

    private PedidoRepositorio repository;

    @Autowired
    PedidoServicio(PedidoRepositorio repository){
        this.repository = repository;
    }

}
