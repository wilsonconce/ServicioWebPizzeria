package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.repositorios.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServicio {

    @Autowired
    SucursalRepositorio sucursalRepositorio;

    public List<Sucursal> findAll(){
        return (List<Sucursal>) sucursalRepositorio.findAll();
    }

    public Sucursal retriveSucursalByNombre(String nombre){
        return (Sucursal) sucursalRepositorio.findSucursalByNombre(nombre);
    }

    public String retriveSucursalNombreByCodigo(int codigo){
        return (String) sucursalRepositorio.findSucursalNombreByCodigo(codigo);
    }

    public List<String> retriveAllNombres(){
        return (List<String>) sucursalRepositorio.findAllNombres();
    }

}
