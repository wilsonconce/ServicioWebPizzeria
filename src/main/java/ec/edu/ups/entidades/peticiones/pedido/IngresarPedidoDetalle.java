package ec.edu.ups.entidades.peticiones.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;

public class IngresarPedidoDetalle {

    @JsonProperty
    private int codigoPedido;

    @JsonProperty
    private String descripcion;

    @JsonProperty
    private String nombreProducto;

    @JsonProperty
    private String cedulaUsuario;

    @JsonProperty
    private Time tiempoAprox;

    @JsonProperty
    private double distanciaRecorrido;

    @JsonProperty
    private double costoEnvio;

    @JsonProperty
    private int cantidad;

    @JsonProperty
    private double precioUnitario;

    @JsonProperty
    private double precioTotal;

    @JsonProperty
    private double iva;

    @JsonProperty
    private double subtotalFac;

    @JsonProperty
    private double totalFac;

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSubtotalFac() {
        return subtotalFac;
    }

    public void setSubtotalFac(double subtotalFac) {
        this.subtotalFac = subtotalFac;
    }

    public double getTotalFac() {
        return totalFac;
    }

    public void setTotalFac(double totalFac) {
        this.totalFac = totalFac;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public Time getTiempoAprox() {
        return tiempoAprox;
    }

    public void setTiempoAprox(Time tiempoAprox) {
        this.tiempoAprox = tiempoAprox;
    }

    public double getDistanciaRecorrido() {
        return distanciaRecorrido;
    }

    public void setDistanciaRecorrido(double distanciaRecorrido) {
        this.distanciaRecorrido = distanciaRecorrido;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }
}
