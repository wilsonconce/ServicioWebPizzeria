package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ClienteRepositorio extends CrudRepository<Usuario,String> {
}
