package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepositorio extends CrudRepository<Factura,Integer> {

    @Query("SELECT f FROM Factura f inner join Pedido p on(p.pedidoFactura=f.codigoFactura) WHERE p.idPedido =:codigo")
    Factura buscarFacturaPorPedido(int codigo);


}
