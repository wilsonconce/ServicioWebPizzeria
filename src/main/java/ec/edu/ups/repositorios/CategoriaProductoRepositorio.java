package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.CategoriaProducto;
import ec.edu.ups.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaProductoRepositorio extends CrudRepository<CategoriaProducto, Integer> {

    @Query("select cp from CategoriaProducto cp where cp.nombre =:nombre")
    CategoriaProducto findCategoriaProductoByNombre(String nombre);

    @Query("select cp.codigoCategoria, cp.nombre from CategoriaProducto cp where cp.codigoCategoria =:codigoCategoria")
    String findCategoriaProductoNombreByCodigo(int codigoCategoria);

    @Query("select cp.nombre from CategoriaProducto cp")
    List<String> findAllNombres();


}
