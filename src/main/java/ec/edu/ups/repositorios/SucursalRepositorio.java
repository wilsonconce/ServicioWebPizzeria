package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.CategoriaProducto;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SucursalRepositorio extends CrudRepository<Sucursal, Integer> {

    @Query("select s from Sucursal s where s.nombre =:nombre")
    Sucursal findSucursalByNombre(String nombre);


    @Query("select s from Sucursal s where s.nombre =:nombre")
    Optional<Sucursal> findSucursalByName(String nombre);
    @Query("select s.codigo, s.nombre from Sucursal s where s.codigo =:codigo")
    String findSucursalNombreByCodigo(int codigo);

    @Query("select s.nombre from Sucursal s") //OK
    List<String> findAllNombres();

    @Query("select s.codigo from Sucursal s where s.nombre =:nombre")
    Integer codigoPorNombre(String nombre);

    @Query("select s.latencia from Sucursal s where s.nombre =:nombre")
    Double latitudPorNombre(String nombre);

    @Query("select s.longitud from Sucursal s where s.nombre =:nombre")
    Double longitudPorNombre(String nombre);

    @Query("select s from Sucursal s where s.codigo =:codigo")
    Sucursal sucursalPorCodigo(Integer codigo);
}
