package com.integrador.proyecto.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.proyecto.repositorio.UsuarioRepositorio;
import modelo.Usuario;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarTodos() {
        return usuarioRepositorio.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public void eliminar(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    public Usuario autenticar(String correo, String password) throws Exception {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findByCorreo(correo);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            if (usuario.getPassword().equals(password)) {
                return usuario;
            } else {
                throw new Exception("Contraseña incorrecta");
            }
        }
        return null;
    }
}