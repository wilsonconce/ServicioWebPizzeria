package ec.edu.ups.controlador;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.servicio.DatoNoEncontrado;
import ec.edu.ups.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ControladorProducto {

    private ProductoServicio productoServicio;

    @Autowired
    public void setProductoServicio(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("producto/{nombre}")
    public ResponseEntity<Producto> getProductoByNombre(@PathVariable String nombre){
        Optional<Producto> productoOptional = Optional.ofNullable(productoServicio.retriveProductoByNombre(nombre));
        Producto producto = productoOptional.orElseThrow(DatoNoEncontrado::new);
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }
/*
    @PostMapping("direccion/create")
    public ResponseEntity<Direccion> createPersona(@RequestBody CrearDireccion crearDireccion){

        Optional<Persona> persona = personaServicio.findByCodigo(crearDireccion.getCodigoPersona());
        if(persona.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Direccion direccion = new Direccion();
        direccion.setCallePrincipal(crearDireccion.getCallePrincipal());
        direccion.setCalleSecundaria(crearDireccion.getCalleSecundaria());
        direccion.setNumeracion(crearDireccion.getNumeracion());
        direccion.setPersona(persona.get());

        direccionServicio.save(direccion);
        return ResponseEntity.ok(direccion);
    }*/

}
