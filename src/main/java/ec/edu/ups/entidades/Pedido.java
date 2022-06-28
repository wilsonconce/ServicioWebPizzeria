package ec.edu.ups.entidades;
import javax.persistence.*;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author johan
 */
@Entity
public class Pedido implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;

    private Time tiempoAprox;
    private boolean estado;

    @ManyToOne
    @JoinColumn
    private Sucursal sucursal;

    private double distanciaRecorrido;
    private double costoEnvio;

    @ManyToOne
    @JoinColumn
    private Cuenta cuentaPedido;

    @OneToOne
    @JoinColumn
    private Factura pedidoFactura;

    public Pedido() {
    }

    public Pedido(Time tiempoAprox, boolean estado, Sucursal sucursal, double distanciaRecorrido, double costoEnvio, Cuenta cuentaPedido, Factura factura) {
        this.tiempoAprox = tiempoAprox;
        this.estado = estado;
        this.sucursal = sucursal;
        this.distanciaRecorrido = distanciaRecorrido;
        this.costoEnvio = costoEnvio;
        this.cuentaPedido = cuentaPedido;
        this.pedidoFactura = factura;
    }


    public Time getTiempoAprox() {
        return tiempoAprox;
    }

    public void setTiempoAprox(Time tiempoAprox) {
        this.tiempoAprox = tiempoAprox;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cuenta getCuentaPedido() {
        return cuentaPedido;
    }

    public void setCuentaPedido(Cuenta cuentaPedido) {
        this.cuentaPedido = cuentaPedido;
    }


    public Factura getFactura() {
        return pedidoFactura;
    }

    public void setFactura(Factura factura) {
        this.pedidoFactura = factura;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", tiempoAprox=" + tiempoAprox + ", estado=" + estado + ", sucursal=" + sucursal + ", distanciaRecorrido=" + distanciaRecorrido + ", costoEnvio=" + costoEnvio + ", cuentaPedido=" + cuentaPedido + ", factura=" + pedidoFactura + '}';
    }



}
