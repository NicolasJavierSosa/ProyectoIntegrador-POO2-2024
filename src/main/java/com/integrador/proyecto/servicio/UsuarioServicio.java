package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.proyecto.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    private UsuarioRepositorio repository;

    @Autowired
    UsuarioServicio(UsuarioRepositorio repository){
        this.repository = repository;
    }

}
