package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.proyecto.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServicio {

    private CategoriaRepositorio repository;

    @Autowired
    CategoriaServicio(CategoriaRepositorio repository){
        this.repository = repository;
    }

}
