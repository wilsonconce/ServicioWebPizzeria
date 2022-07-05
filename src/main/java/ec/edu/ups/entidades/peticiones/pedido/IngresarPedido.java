package ec.edu.ups.entidades.peticiones.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;

public class IngresarPedido {

    @JsonProperty
    private String correoUsuario;

    @JsonProperty
    private int codigoFactura;

    @JsonProperty
    private int codigoDetallePedido;

    @JsonProperty
    private Time tiempoAprox;

    @JsonProperty
    private double costoEnvio;

    @JsonProperty
    private double latitudUsuario;

    @JsonProperty
    private double lingitudUsuario;

    @JsonProperty
    private String sucursalNombre;

    @JsonProperty
    private double distancia;

    @JsonProperty
    private String estadoPedido;

    @JsonProperty
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getSucursalNombre() {
        return sucursalNombre;
    }

    public void setSucursalNombre(String sucursalNombre) {
        this.sucursalNombre = sucursalNombre;
    }

    public double getLatitudUsuario() {
        return latitudUsuario;
    }

    public void setLatitudUsuario(double latitudUsuario) {
        this.latitudUsuario = latitudUsuario;
    }

    public double getLingitudUsuario() {
        return lingitudUsuario;
    }

    public void setLingitudUsuario(double lingitudUsuario) {
        this.lingitudUsuario = lingitudUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getCodigoDetallePedido() {
        return codigoDetallePedido;
    }

    public void setCodigoDetallePedido(int codigoDetallePedido) {
        this.codigoDetallePedido = codigoDetallePedido;
    }

    public Time getTiempoAprox() {
        return tiempoAprox;
    }

    public void setTiempoAprox(Time tiempoAprox) {
        this.tiempoAprox = tiempoAprox;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }
}
