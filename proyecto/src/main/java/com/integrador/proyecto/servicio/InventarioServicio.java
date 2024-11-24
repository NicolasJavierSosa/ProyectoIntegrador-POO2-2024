package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.proyecto.repositorio.InventarioRepositorio;

@Service
public class InventarioServicio {

    private InventarioRepositorio repository;

    @Autowired
    InventarioServicio(InventarioRepositorio repository){
        this.repository = repository;
    }

}
