package ec.edu.ups.servicio;

import ec.edu.ups.entidades.CategoriaProducto;

import ec.edu.ups.repositorios.CategoriaProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoServicio {

    @Autowired
    CategoriaProductoRepositorio categoriaProductoRepositorio;

    public List<CategoriaProducto> findAll(){
        return (List<CategoriaProducto>) categoriaProductoRepositorio.findAll();
    }

    public CategoriaProducto retriveCategoriaProductoByNombre(String nombre){
        return (CategoriaProducto) categoriaProductoRepositorio.findCategoriaProductoByNombre(nombre);
    }

    public String retriveCategoriaProductoNombreByCodigo(int codigo){
        return (String) categoriaProductoRepositorio.findCategoriaProductoNombreByCodigo(codigo);
    }

    public List<String> retriveAllNombres(){
        return (List<String>) categoriaProductoRepositorio.findAllNombres();
    }



}
