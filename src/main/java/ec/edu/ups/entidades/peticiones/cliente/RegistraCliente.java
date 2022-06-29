package ec.edu.ups.entidades.peticiones.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.entidades.TipoUsuario;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.Date;

public class RegistraCliente {

    @JsonProperty
    private String cedula;
    @JsonProperty
    private String nombre;
    @JsonProperty
    private String apellido;
    @JsonProperty
    private Date fechaNacimiento;
    @JsonProperty
    private int codtipoUsuario;
    @JsonProperty
    private int codigoCuenta;

    @JsonProperty
    private String correo;

    @JsonProperty
    private String contrasena;


    public RegistraCliente() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodtipoUsuario() {
        return codtipoUsuario;
    }

    public void setCodtipoUsuario(int codtipoUsuario) {
        this.codtipoUsuario = codtipoUsuario;
    }

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
