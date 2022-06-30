package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.CategoriaProducto;
import ec.edu.ups.entidades.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SucursalRepositorio extends CrudRepository<Sucursal, Integer> {

    @Query("select s from Sucursal s where s.nombre =:nombre")
    Sucursal findSucursalByNombre(String nombre);

    @Query("select s.codigo, s.nombre from Sucursal s where s.codigo =:codigo")
    String findSucursalNombreByCodigo(int codigo);

    @Query("select s.nombre from Sucursal s") //OK
    List<String> findAllNombres();

}
