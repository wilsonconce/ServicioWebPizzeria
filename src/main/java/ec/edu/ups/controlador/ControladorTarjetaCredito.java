package ec.edu.ups.controlador;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.TarjetaCredito;
import ec.edu.ups.entidades.TipoUsuario;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.entidades.peticiones.cliente.RegistraCliente;
import ec.edu.ups.entidades.peticiones.tarjetacredito.CrearTarjeta;
import ec.edu.ups.servicio.CuentaNoEncontradaException;
import ec.edu.ups.servicio.CuentaServicio;
import ec.edu.ups.servicio.TarjetaCreditoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ControladorTarjetaCredito {

    private TarjetaCreditoServicio tarjetaCreditoServicio;

    private CuentaServicio cuentaServicio;

    @Autowired
    public void setTarjetaCreditoServicio(TarjetaCreditoServicio tarjetaCreditoServicio) {
        this.tarjetaCreditoServicio = tarjetaCreditoServicio;
    }

    @Autowired
    public void setCuentaServicio(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }
    @PostMapping("/cuenta/tarjeta")
    public ResponseEntity<TarjetaCredito> createCliente(@RequestBody CrearTarjeta crearTarjeta){
        Optional<Cuenta> cuenta=cuentaServicio.findByCodigo(crearTarjeta.getCodigoCuenta());
        if(cuenta.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        TarjetaCredito tarjetaCredito=new TarjetaCredito();
        tarjetaCredito.setNumeroTarjeta(crearTarjeta.getNumeroTarjeta());
        tarjetaCredito.setCodigoSegu(crearTarjeta.getCodigoSegu());
        tarjetaCredito.setFechaCa(crearTarjeta.getFechaCa());
        tarjetaCredito.setNombreTarj(crearTarjeta.getNombreTarj());
        tarjetaCredito.setCuenta(cuenta.get());
        tarjetaCreditoServicio.save(tarjetaCredito);
        return ResponseEntity.ok(tarjetaCredito);

    }
    @GetMapping("/cuenta/{codigo}")
    public ResponseEntity<Cuenta> getCuentaByCodigo(@PathVariable int codigo){
        Optional<Cuenta> personaOptional=(cuentaServicio.findByCodigo(codigo));
        Cuenta cuenta=personaOptional.orElseThrow(CuentaNoEncontradaException::new);
        return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
    }
    @DeleteMapping("/tarjeta/delete/{codigo}")
    public ResponseEntity<String> deletePersona(@PathVariable int codigo) {
        this.tarjetaCreditoServicio.delete(codigo);
        return ResponseEntity .ok("Tarjeta de Credito Eliminada correctamente");
    }

}
