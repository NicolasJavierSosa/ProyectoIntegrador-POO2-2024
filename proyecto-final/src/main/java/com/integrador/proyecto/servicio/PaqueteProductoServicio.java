package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.proyecto.repositorio.PaqueteProductoRepositorio;

@Service
public class PaqueteProductoServicio {

    @Autowired
    private PaqueteProductoRepositorio repository;

    @Autowired
    PaqueteProductoServicio(PaqueteProductoRepositorio repository){
        this.repository = repository;
    }



}
