package ec.edu.ups.controlador;

import ec.edu.ups.entidades.CategoriaProducto;
import ec.edu.ups.entidades.Sucursal;
import ec.edu.ups.servicio.CategoriaProductoServicio;
import ec.edu.ups.servicio.SucursalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorSucursal {

    private SucursalServicio sucursalServicio;

    @Autowired
    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }

    @GetMapping("sucursalproducto/{nombre}")
    public ResponseEntity<Sucursal> getSucursalByNombre(@PathVariable String nombre){
        System.out.println(nombre);
        Sucursal sucursal = sucursalServicio.retriveSucursalByNombre(nombre);
        System.out.println(sucursal);
        return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
    }

    @GetMapping("sucursal/{codigo}")
    public ResponseEntity<String> getSucursalNombreByCodigo(@PathVariable int codigo){
        String nombre = sucursalServicio.retriveSucursalNombreByCodigo(codigo);
        return new ResponseEntity<String>(nombre, HttpStatus.OK);
    }

    @GetMapping("/sucursales/nombres")
    public ResponseEntity<List<String>> getAllSucursalesNombres(){
        List<String> listaSucursalesNombres = sucursalServicio.retriveAllNombres();
        return new ResponseEntity<List<String>>(listaSucursalesNombres, HttpStatus.OK);
    }

}
