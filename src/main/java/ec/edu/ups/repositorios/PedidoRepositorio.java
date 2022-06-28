package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepositorio extends CrudRepository<Pedido, Long> {
}
