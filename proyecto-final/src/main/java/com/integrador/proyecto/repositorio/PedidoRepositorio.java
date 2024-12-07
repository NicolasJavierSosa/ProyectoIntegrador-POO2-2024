package com.integrador.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import modelo.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer>{

}
