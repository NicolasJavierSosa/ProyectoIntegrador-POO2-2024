package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.proyecto.repositorio.PaqueteRepositorio;

@Service
public class PaqueteServicio {

    private PaqueteRepositorio repository;

    @Autowired
    PaqueteServicio(PaqueteRepositorio repository){
        this.repository = repository;
    }

}
