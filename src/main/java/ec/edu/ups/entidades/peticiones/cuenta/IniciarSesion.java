package ec.edu.ups.entidades.peticiones.cuenta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IniciarSesion {

    @JsonProperty
    private String correo;
    @JsonProperty
    private String contrasena;

    public IniciarSesion() {
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
