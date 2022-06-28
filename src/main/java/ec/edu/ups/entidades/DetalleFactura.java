package ec.edu.ups.entidades;
import javax.persistence.*;

import java.io.Serializable;

/**
 *
 * @author johan
 */
@Entity
public class DetalleFactura implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoDetalle;
    private String descripcion;
    private double precioUnitario;
    private int cantidad;
    private double precioTotal;

    @OneToOne
    @JoinColumn
    private Producto producto;

    @ManyToOne
    @JoinColumn
    private Factura facturadetalle;

    public DetalleFactura() {
    }


    public DetalleFactura(String descripcion, double precioUnitario, int cantidad, double precioTotal, Producto producto, Factura facturadetalle) {
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.producto = producto;
        this.facturadetalle = facturadetalle;
    }

    public int getCodigoDetalle() {
        return codigoDetalle;
    }

    public void setCodigoDetalle(int codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFacturadetalle() {
        return facturadetalle;
    }

    public void setFacturadetalle(Factura facturadetalle) {
        this.facturadetalle = facturadetalle;
    }

    @Override
    public String toString() {
        String u = ",facturadetalle==(null)";
        if (this.facturadetalle != null) {
            u = ", facturadetalle=(" + this.facturadetalle.getCodigoFactura() + ")";
        }
        return "DetalleFactura{" + "codigoDetalle=" + codigoDetalle + ", descripcion=" + descripcion + u + '}';
    }




}
