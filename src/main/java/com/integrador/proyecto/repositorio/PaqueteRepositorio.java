package com.integrador.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import modelo.Paquete;

@Repository
public interface PaqueteRepositorio extends JpaRepository<Paquete, Integer>{

}
