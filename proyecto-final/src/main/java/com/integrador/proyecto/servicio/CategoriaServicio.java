package com.integrador.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.proyecto.repositorio.CategoriaRepositorio;
import modelo.Categoria;
import modelo.Producto;


@Service
public class CategoriaServicio {
    
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public CategoriaServicio(CategoriaRepositorio categoriaRepositorio){
        this.categoriaRepositorio = categoriaRepositorio;
    }

    public List<Categoria> obtenerTodasCategorias(){
        return categoriaRepositorio.findAll();
    }

    public List<Producto> obtenerProductosPorCategoria(int idCategoria) {
        return categoriaRepositorio.findById(idCategoria)
            .map(categoria -> new ArrayList<>(categoria.getProductos()))
            .orElseGet(ArrayList::new);
    }

}
