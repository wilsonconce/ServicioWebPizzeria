package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    public void save(Usuario usuario){
        clienteRepositorio.save(usuario);
    }
    public List<Usuario> findAll(){
        return (List<Usuario>) clienteRepositorio.findAll();
    }
}
