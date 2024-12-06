package com.integrador.proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.integrador.proyecto.servicio.UsuarioServicio;
import modelo.Usuario;

@Controller
@RequestMapping("/registro")
public class RegistrarseController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public String mostrarFormularioDeCrear(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping
    public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
        List<Usuario> usuarios = usuarioServicio.listarTodos();
        if(usuario.getApellido().isBlank() ||
            usuario.getCorreo().isBlank() ||
            usuario.getNombre().isBlank() ||
            usuario.getPassword().isBlank() ||
            usuario.getUsername().isBlank()){
                model.addAttribute("alerta", "Rellene todos los campos");
                return "/registro";
            }
        else{
            for(int i = 0; i < usuarios.size(); i++){
                if(usuario.getUsername().equals(usuarios.get(i).getUsername())){
                    model.addAttribute("alerta", "Ese usuario ya se encuentra en uso");
                    return "/registro";
                }
            }
        }
        usuarioServicio.guardar(usuario);
        return "redirect:/sesion";
    }
}