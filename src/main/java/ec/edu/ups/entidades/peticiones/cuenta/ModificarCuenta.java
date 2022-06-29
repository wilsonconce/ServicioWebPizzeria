package ec.edu.ups.entidades.peticiones.cuenta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModificarCuenta {

    @JsonProperty
    private int codigoCuenta;
    @JsonProperty
    private String contrasena;

    public ModificarCuenta() {
    }

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
