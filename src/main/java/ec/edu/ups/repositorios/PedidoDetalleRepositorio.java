package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.PedidoDetalle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PedidoDetalleRepositorio extends CrudRepository<PedidoDetalle, Integer> {

    @Query("SELECT u FROM PedidoDetalle u WHERE u.codigoDetalle =:codigo")
    Optional<PedidoDetalle> buscarDetalleID(int codigo);


}


