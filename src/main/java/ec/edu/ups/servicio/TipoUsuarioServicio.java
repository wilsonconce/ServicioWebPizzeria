package ec.edu.ups.servicio;

import ec.edu.ups.entidades.TipoUsuario;
import ec.edu.ups.repositorios.TipoUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TipoUsuarioServicio {

    @Autowired
    TipoUsuarioRepositorio tipoUsuarioRepositorio;

    public TipoUsuario findbyCodigo(int codigo){
       return (TipoUsuario) tipoUsuarioRepositorio.findTipoUsuarioId(codigo);
    }
}
