package ec.edu.ups.controlador;

import ec.edu.ups.entidades.Cuenta;
import ec.edu.ups.entidades.TipoUsuario;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.entidades.peticiones.cliente.RegistraCliente;
import ec.edu.ups.entidades.peticiones.cuenta.ModificarCuenta;
import ec.edu.ups.servicio.ClienteServicio;
import ec.edu.ups.servicio.CuentaServicio;
import ec.edu.ups.servicio.TipoUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorCliente {


    private ClienteServicio clienteServicio;

    private CuentaServicio cuentaServicio;

    private TipoUsuarioServicio tipoUsuarioServicio;

    @Autowired
    public void setTipoUsuarioServicio(TipoUsuarioServicio tipoUsuarioServicio) {
        this.tipoUsuarioServicio = tipoUsuarioServicio;
    }

    @Autowired
    public void setClienteServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @Autowired
    public void setCuentaServicio(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }
    @PostMapping("/cliente/registrar")
    public ResponseEntity<Usuario> createCliente(@RequestBody RegistraCliente registraCliente){
        TipoUsuario tipoUsuario=tipoUsuarioServicio.findbyCodigo(3);
        Usuario usuario=new Usuario();
        usuario.setCedula(registraCliente.getCedula());
        usuario.setNombre(registraCliente.getNombre());
        usuario.setApellido(registraCliente.getApellido());
        usuario.setFechaNacimiento(registraCliente.getFechaNacimiento());
        usuario.setTipoUsuario(tipoUsuario);
        Cuenta cuenta=new Cuenta();
        cuenta.setCorreo(registraCliente.getCorreo());
        cuenta.setContrasena(registraCliente.getContrasena());
        cuenta.setUsuario(usuario);
        usuario.setCuenta(cuenta);

        System.out.println(usuario);
        clienteServicio.save(usuario);
        return ResponseEntity.ok(usuario);

    }
    @PutMapping("/cuenta/edit")
    public ResponseEntity <Cuenta> updatePersona(@RequestBody ModificarCuenta modificarCuenta) {
        Optional<Cuenta> cuentaOptional = this.cuentaServicio.findByCodigo(modificarCuenta.getCodigoCuenta());
        if(cuentaOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Cuenta cuenta=cuentaOptional.get();
        cuenta.setContrasena(modificarCuenta.getContrasena());
        this.cuentaServicio.save(cuenta);
        return ResponseEntity.ok(cuenta);
    }
    @GetMapping("/clientes")
    public ResponseEntity<List<Usuario>> getAllPersona(){

        List<Usuario> listapersonas=clienteServicio.findAll();

        return new ResponseEntity<List<Usuario>>(listapersonas, HttpStatus.OK);
    }
}
