package com.integrador.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String>{

}
