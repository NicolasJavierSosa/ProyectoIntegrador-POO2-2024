package com.integrador.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.proyecto.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {

    private ProductoRepositorio repository;

    @Autowired
    ProductoServicio(ProductoRepositorio repository){
        this.repository = repository;
    }

}
