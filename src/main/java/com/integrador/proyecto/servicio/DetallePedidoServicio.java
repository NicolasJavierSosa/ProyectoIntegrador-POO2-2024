package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.proyecto.repositorio.DetallePedidoRepositorio;
import modelo.DetallePedido;

@Service
public class DetallePedidoServicio {

    @Autowired
    private DetallePedidoRepositorio repository;

    @Autowired
    DetallePedidoServicio(DetallePedidoRepositorio repository){
        this.repository = repository;
    }

    public void guardarDetalle(DetallePedido detalle){
        repository.save(detalle);
    }

}
