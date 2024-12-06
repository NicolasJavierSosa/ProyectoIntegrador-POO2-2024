package com.integrador.proyecto.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.integrador.proyecto.repositorio.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

@Controller
public class SesionController {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public SesionController(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // Mostrar la página de inicio de sesión
    @GetMapping("/sesion")
    public String mostrarPaginaSesion(Model model) {
        model.addAttribute("usuario", new Usuario()); // Asegúrate de pasar un objeto usuario vacío
        return "sesion"; // Renderiza la vista sesion.html
    }

    // Lógica para iniciar sesión
    @PostMapping("/sesion")
    public String iniciarSesion(
        @ModelAttribute("usuario") Usuario usuario, // Usamos @ModelAttribute para el binding del objeto
        HttpSession session,
        Model model) {

            Optional<Usuario> usuarioOpt = usuarioRepositorio.findByCorreo(usuario.getCorreo());

            if (usuarioOpt.isPresent()) {
                Usuario usuarioDB = usuarioOpt.get();

                // * INSEGURO: Sustituir con bcrypt u otro método seguro *
                if (usuarioDB.getPassword().equals(usuario.getPassword())) {
                    session.setAttribute("usuario", usuarioDB);
                    return "redirect:/"; // Redirige al inicio
                } else {
                    model.addAttribute("alerta", "Correo o contraseña incorrecto");
                    return "sesion"; // Vuelve al formulario de sesión con un mensaje de error
                }
            } else {
                // Si el usuario no existe, redirige al registro
                model.addAttribute("alerta", "Correo o contraseña incorrecto");
                return "sesion"; // Redirige a la página de sesión
            }
        }

    // Cerrar sesión
    @GetMapping("/cerrar-sesion")
    public String cerrarSesion(HttpSession session) {
        session.invalidate(); // Invalidar la sesión
        return "redirect:/"; // Redirigir al inicio
    }

    // Página de inicio
    @GetMapping("/sesion/inicio")
    public String inicio(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            model.addAttribute("usuario", usuario); // Agregar el usuario autenticado al modelo
        } else {
            model.addAttribute("mensaje", "Bienvenido, visitante");
        }

        return "inicio"; // Devolver la vista de inicio
    }
}