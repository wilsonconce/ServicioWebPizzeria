package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicio {

    @Autowired
    PedidoRepositorio pedidoRepositorio;

    public List<Pedido> findAll(){
        return (List<Pedido>) pedidoRepositorio.findAll();
    }

    public void savePedido(Pedido pedido){
    pedidoRepositorio.save(pedido);
    }


}
