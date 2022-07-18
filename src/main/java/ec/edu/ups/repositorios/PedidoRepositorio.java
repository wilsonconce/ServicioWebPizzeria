package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepositorio extends CrudRepository<Pedido, Integer> {

@Query("SELECT u FROM Pedido u WHERE u.idPedido =:codigo")
    Optional <Pedido> buscarPedidoID(int codigo);

    @Query("SELECT u FROM Pedido u WHERE u.idPedido =:codigo")
    Pedido buscarPorCodigo(int codigo);

    @Query("SELECT p FROM Pedido p WHERE p.cuentaPedido.codigoCuenta =:codigo")
    List< Pedido> buscarPorCuenta(int codigo);
}
