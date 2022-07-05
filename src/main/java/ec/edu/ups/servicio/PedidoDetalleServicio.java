package ec.edu.ups.servicio;

import ec.edu.ups.entidades.PedidoDetalle;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.repositorios.PedidoDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoDetalleServicio {

    @Autowired
    PedidoDetalleRepositorio pedidoDetalleRepositorio;

    public void save(PedidoDetalle pedidoDetalle){
        pedidoDetalleRepositorio.save(pedidoDetalle);
    }
}
