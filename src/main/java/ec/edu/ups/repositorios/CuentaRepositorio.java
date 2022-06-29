package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CuentaRepositorio extends CrudRepository<Cuenta,Integer>{

    @Query("select c from Cuenta c where c.correo = :correo")
    Optional <Cuenta> findCuentaByCorreo(String correo);
}
