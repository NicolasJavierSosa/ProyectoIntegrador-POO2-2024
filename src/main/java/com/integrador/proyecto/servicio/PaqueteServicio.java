package com.integrador.proyecto.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.proyecto.repositorio.PaqueteRepositorio;
import modelo.Paquete;

@Service
public class PaqueteServicio {

    @Autowired
    private PaqueteRepositorio repository;

    @Autowired
    PaqueteServicio(PaqueteRepositorio repository){
        this.repository = repository;
    }

    public void guardarPaquete(Paquete paquete){
        repository.save(paquete);
    }

    public List<Paquete> buscarPaquetes(){
        List<Paquete> x = repository.findAll();
        return x;
    }

    public void eliminarPaquete(Integer idPaquete){
        repository.deleteById(idPaquete);
    }

}
