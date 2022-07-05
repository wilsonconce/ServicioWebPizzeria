package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Factura;
import ec.edu.ups.entidades.PedidoDetalle;
import ec.edu.ups.repositorios.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServicio {

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    public void save(Factura factura){
        facturaRepositorio.save(factura);
    }

}
