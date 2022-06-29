package ec.edu.ups.entidades.peticiones.cuenta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistraCuenta {
    @JsonProperty
    private String correo;
    @JsonProperty
    private String contrasena;
    @JsonProperty
    private String cedulaUsuario;

    public RegistraCuenta() {
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

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }
}
