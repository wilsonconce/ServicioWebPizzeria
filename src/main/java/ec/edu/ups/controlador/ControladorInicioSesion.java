package ec.edu.ups.controlador;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.peticiones.cuenta.IniciarSesion;
import ec.edu.ups.servicio.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ControladorInicioSesion {

    private CuentaServicio cuentaServicio;

    @Autowired
    public void setCuentaServicio(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }
    @GetMapping("/iniciarsesion")
    public ResponseEntity<String> iniciarSesion(@RequestBody IniciarSesion iniciarSesion){
        Optional<Cuenta> cuentaOptional= (Optional<Cuenta>)(cuentaServicio.findByCorreo(iniciarSesion.getCorreo()));
        if(cuentaOptional.isEmpty()){
            return new ResponseEntity<String>("Corrreo incorrecto", HttpStatus.OK);
        }
        Cuenta cuenta=cuentaOptional.get();
        if(cuenta.getContrasena().equals(iniciarSesion.getContrasena())){
            return new ResponseEntity<String>("Usuario Logueado Correctamente", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Password Incorrecto", HttpStatus.OK);
        }
    }
}
