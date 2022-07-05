package ec.edu.ups.servicio;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.repositorios.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Sucursal> retriveSucursalByName(String nombre){
        return (Optional<Sucursal>) sucursalRepositorio.findSucursalByName(nombre);
    }

    public String retriveSucursalNombreByCodigo(int codigo){
        return (String) sucursalRepositorio.findSucursalNombreByCodigo(codigo);
    }

    public List<String> retriveAllNombres(){
        return (List<String>) sucursalRepositorio.findAllNombres();
    }

    public Integer codigoPorNombre(String nombre){
        return sucursalRepositorio.codigoPorNombre(nombre);
    }

    public Double latitudPorNombre(String nombre){
        return sucursalRepositorio.latitudPorNombre(nombre);
    }

    public Double longitudPorNombre(String nombre){
        return sucursalRepositorio.longitudPorNombre(nombre);
    }
    public Sucursal sucursalPorCodigo(Integer codigo){
        return (Sucursal) sucursalRepositorio.sucursalPorCodigo(codigo);
    }

    public void save(Sucursal sucursal){
        sucursalRepositorio.save(sucursal);
    }





}
