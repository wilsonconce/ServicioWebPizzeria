package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    public void save(Producto producto){
        productoRepositorio.save(producto);
    }

    public Producto retriveProductoByNombre(String nombre){
        return (Producto) productoRepositorio.findProductoByNombre(nombre);
    }

    public Double precioPorID(Integer codigoPr){
        return productoRepositorio.findPrecioByID(codigoPr);
    }

    public Integer codigoPorNombre(String nombreP){
        return productoRepositorio.findCodigoByName(nombreP);
    }

    public Producto productoPorCodigo(Integer codPro){
        return (Producto) productoRepositorio.productoPorCodigo(codPro);
    }
    public Integer stockPorId(Integer codigoProd){
        return productoRepositorio.stockPorCodigo(codigoProd);
    }

}
