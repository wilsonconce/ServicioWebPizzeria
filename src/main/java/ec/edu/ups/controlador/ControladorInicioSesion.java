package ec.edu.ups.controlador;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.peticiones.cuenta.IniciarSesion;
import ec.edu.ups.servicio.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class ControladorInicioSesion {

    private CuentaServicio cuentaServicio;

    @Autowired
    public void setCuentaServicio(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }
    @PostMapping("/iniciarsesion")
    public ResponseEntity<Cuenta> iniciarSesion(@RequestBody IniciarSesion iniciarSesion){
        Optional<Cuenta> cuentaOptional= (Optional<Cuenta>)(cuentaServicio.findByCorreo(iniciarSesion.getCorreo()));
        if(cuentaOptional.isEmpty()){
            System.out.println("Correo incorrecto");
            return new ResponseEntity<Cuenta>(HttpStatus.NOT_FOUND);
        }
        Cuenta cuenta=cuentaOptional.get();
        if(cuenta.getContrasena().equals(iniciarSesion.getContrasena())&& cuenta.getUsuario().getTipoUsuario().getDescripcion().equals("Cliente")){
            System.out.println("Usuario Logueado Correctamente");
            return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
        }
        else {
            System.out.println("Contraseña Incorrecta");
            return new ResponseEntity<Cuenta>(HttpStatus.NOT_FOUND);
        }
    }
}
