package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {

    @Query("select p from Producto p  where p.nombre =:nombre")
    Producto findProductoByNombre(String nombre);


    @Query("select p.precio from Producto p  where p.codigoProducto =:codigo")
    Double findPrecioByID(Integer codigo);

    @Query("select p.codigoProducto from Producto p where p.nombre=:nombrePr")
    Integer findCodigoByName(String nombrePr);

    @Query("select p from Producto p where p.codigoProducto =:codigoPro")
    Producto productoPorCodigo(Integer codigoPro);

    @Query("select p.stock from Producto p where p.codigoProducto =:codigoP")
    Integer stockPorCodigo(Integer codigoP);
   }
