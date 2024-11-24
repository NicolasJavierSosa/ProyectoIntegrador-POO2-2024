package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.proyecto.repositorio.DetallePedidoRepositorio;

@Service
public class DetallePedidoServicio {

    private DetallePedidoRepositorio repository;

    @Autowired
    DetallePedidoServicio(DetallePedidoRepositorio repository){
        this.repository = repository;
    }

}
