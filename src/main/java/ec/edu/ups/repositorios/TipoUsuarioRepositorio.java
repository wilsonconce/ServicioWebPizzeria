package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.TipoUsuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TipoUsuarioRepositorio extends CrudRepository<TipoUsuario,Integer> {

    @Query("select t from TipoUsuario t where t.idTipo = :codigo")
    TipoUsuario findTipoUsuarioId(int codigo);
}
