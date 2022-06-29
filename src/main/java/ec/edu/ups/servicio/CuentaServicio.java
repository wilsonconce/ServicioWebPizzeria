package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.TarjetaCredito;
import ec.edu.ups.repositorios.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CuentaServicio {

    @Autowired
    CuentaRepositorio cuentaRepositorio;

    public Optional<Cuenta> findByCodigo(int codigo){
        return (Optional<Cuenta>)cuentaRepositorio.findById(codigo);
    }
    public Optional<Cuenta> findByCorreo(String correo){
        return (Optional<Cuenta>)cuentaRepositorio.findCuentaByCorreo(correo);
    }
    public void save(Cuenta cuenta){cuentaRepositorio.save(cuenta);}
}
