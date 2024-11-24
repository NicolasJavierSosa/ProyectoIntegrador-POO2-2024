package com.integrador.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{

}
