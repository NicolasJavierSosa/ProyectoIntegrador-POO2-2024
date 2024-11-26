package com.integrador.proyecto.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.integrador.proyecto.repositorio.ProductoRepositorio;

import modelo.Producto;

@Service
public class ProductoServicio {
    
    @Autowired
    private final ProductoRepositorio productoRepository;


    public List<Producto> obtenerTodosProductos(){
        return productoRepository.findAll();
    }

    public ProductoServicio(ProductoRepositorio productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto obtenerProductoPorId(String id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            return producto.get(); // Devuelve el producto si está presente
        }
        return null; // Devuelve null si no se encuentra
    }
    

    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Producto> ordenarPorPrecioAsc() {
        return productoRepository.findAll(Sort.by(Sort.Direction.ASC, "precio"));
    }

    public List<Producto> ordenarPorPrecioDesc() {
        return productoRepository.findAll(Sort.by(Sort.Direction.DESC, "precio"));
    }

    public Page<Producto> obtenerProductosPaginados(int pagina, int tamaño) {
        Pageable pageable = PageRequest.of(pagina, tamaño);
        return productoRepository.findAll(pageable);
    }

    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    public void guardarProducto(Producto producto){
        productoRepository.save(producto);
    }

    public void eliminarProducto(String id){
        productoRepository.deleteById(id);
    }
}