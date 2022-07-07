package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ClienteRepositorio extends CrudRepository<Usuario,String> {

    @Query("select c from Usuario c where c.cedula = :cedula")
    Optional<Usuario> findByCedula(String cedula);

}
