package com.integrador.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.proyecto.repositorio.PaqueteRepositorio;

import modelo.ComponenteProducto;
import modelo.Paquete;
import modelo.Producto;

@Service
public class PaqueteServicio {

    private PaqueteRepositorio repository;
    private Paquete compra = new Paquete();

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

    public void eliminarPaquete(String idPaquete){
        repository.deleteById(idPaquete);
    }

    public void agregarCompra(Producto compra){
        this.compra.añadirItem(compra);
    }

}
