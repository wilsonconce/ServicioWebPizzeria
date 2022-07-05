package ec.edu.ups.servicio;

import ec.edu.ups.entidades.DetalleFactura;
import ec.edu.ups.entidades.PedidoDetalle;
import ec.edu.ups.repositorios.FacturaDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaDetalleServicio {

    @Autowired
    private FacturaDetalleRepositorio facturaDetalleRepositorio;

    public void save(DetalleFactura detalleFactura){
        facturaDetalleRepositorio.save(detalleFactura);
    }
}
