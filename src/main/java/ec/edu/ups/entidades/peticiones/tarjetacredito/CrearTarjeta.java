package ec.edu.ups.entidades.peticiones.tarjetacredito;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CrearTarjeta {

    @JsonProperty
    private String numeroTarjeta;
    @JsonProperty
    private Date fechaCa;
    @JsonProperty
    private String codigoSegu;
    @JsonProperty
    private String nombreTarj;
    @JsonProperty
    private int codigoCuenta;

    public CrearTarjeta() {
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Date getFechaCa() {
        return fechaCa;
    }

    public void setFechaCa(Date fechaCa) {
        this.fechaCa = fechaCa;
    }

    public String getCodigoSegu() {
        return codigoSegu;
    }

    public void setCodigoSegu(String codigoSegu) {
        this.codigoSegu = codigoSegu;
    }

    public String getNombreTarj() {
        return nombreTarj;
    }

    public void setNombreTarj(String nombreTarj) {
        this.nombreTarj = nombreTarj;
    }

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }
}
