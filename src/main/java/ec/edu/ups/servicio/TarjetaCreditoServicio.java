package ec.edu.ups.servicio;

import ec.edu.ups.entidades.TarjetaCredito;
import ec.edu.ups.repositorios.TarjetaCreditoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarjetaCreditoServicio {
    @Autowired
    TarjetaCreditoRepositorio tarjetaCreditoRepositorio;

    public Optional<TarjetaCredito> findByCodigo(int codigo){
        return (Optional<TarjetaCredito>)tarjetaCreditoRepositorio.findById(codigo);
    }
    public void save(TarjetaCredito tarjetaCredito){tarjetaCreditoRepositorio.save(tarjetaCredito);}

    public void delete(int codigo){
        tarjetaCreditoRepositorio.deleteById(codigo);

    }
}
