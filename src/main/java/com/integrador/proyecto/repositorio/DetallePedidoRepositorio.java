package com.integrador.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import modelo.DetallePedido;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer>{

}
