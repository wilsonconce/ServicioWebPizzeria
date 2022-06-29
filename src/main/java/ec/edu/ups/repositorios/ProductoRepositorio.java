package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {

    @Query("select p from Producto p  where p.nombre =:nombre")
    Producto findProductoByNombre(String nombre);
}
