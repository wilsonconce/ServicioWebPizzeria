package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public void save(Pedido pedido){
        pedidoRepositorio.save(pedido);
    }

}
