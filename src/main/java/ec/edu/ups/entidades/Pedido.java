package ec.edu.ups.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

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

   @Enumerated(value = EnumType.ORDINAL)
   private EstadoPedido estado;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Sucursal sucursal;

    private double distanciaRecorrido;
    private double costoEnvio;
    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Cuenta cuentaPedido;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Factura pedidoFactura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoDetalle")
    private List<PedidoDetalle> pedidoDetalle;

    public Pedido() {
        estado= EstadoPedido.ENVIADO;
    }

    public Pedido(Time tiempoAprox, EstadoPedido estado, Sucursal sucursal, double distanciaRecorrido, double costoEnvio, Cuenta cuentaPedido, Factura factura) {
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

    public EstadoPedido isEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
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


    public Factura getPedidoFactura() {
        return pedidoFactura;
    }

    public void setPedidoFactura(Factura pedidoFactura) {
        this.pedidoFactura = pedidoFactura;
    }

    public List<PedidoDetalle> getPedidoDetalle() {
        return pedidoDetalle;
    }

    public void setPedidoDetalle(List<PedidoDetalle> pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
    }

    public void calcularSubtotal(){

    }

    @Override
    public String toString() {
        String s =",sucursal==(null)";
        String c =",cuentaPedido==(null)";
        String d = ", pedidoDetalle=(null)";
        if (this.pedidoDetalle != null) {
            d = ", pedidoDetalle=" + this.pedidoDetalle.toString() + ")";
        }
        if (this.sucursal != null) {
            s = ", Sucursal=(" + this.sucursal.getCodigo() + ")";
        }
        if (this.cuentaPedido != null) {
            c = ", Cuenta=(" + this.cuentaPedido.getCodigoCuenta() + ")";
        }
        return "Pedido{" + "idPedido=" + idPedido + ", tiempoAprox=" + tiempoAprox + ", estado=" + estado + s + ", distanciaRecorrido=" + distanciaRecorrido + ", costoEnvio=" + costoEnvio  + c + d+'}';
    }



}
