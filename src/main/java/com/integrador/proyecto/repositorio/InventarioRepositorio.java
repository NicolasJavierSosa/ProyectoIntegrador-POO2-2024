package com.integrador.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.Inventario;

@Repository
public interface InventarioRepositorio extends JpaRepository<Inventario, String>{

}
