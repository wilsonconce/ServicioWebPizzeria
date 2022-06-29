package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.repositorios.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServicio {

    @Autowired
    CuentaRepositorio cuentaRepositorio;
    public void save(Cuenta cuenta){cuentaRepositorio.save(cuenta);}
}
