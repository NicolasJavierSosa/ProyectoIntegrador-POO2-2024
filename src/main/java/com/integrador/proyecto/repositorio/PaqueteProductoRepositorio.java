package com.integrador.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import modelo.PaqueteProducto;

@Repository
public interface PaqueteProductoRepositorio extends JpaRepository<PaqueteProducto, Integer>{

}
