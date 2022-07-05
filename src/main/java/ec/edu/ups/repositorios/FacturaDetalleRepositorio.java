package ec.edu.ups.repositorios;

import ec.edu.ups.entidades.DetalleFactura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaDetalleRepositorio extends CrudRepository<DetalleFactura, Integer> {

}
