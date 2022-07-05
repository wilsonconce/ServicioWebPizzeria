package ec.edu.ups.entidades;
import javax.persistence.*;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author johan
 */
@Entity
public class Factura implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoFactura;

    private Date fechaFactura;
    private double subtotal;
    private double iva;
    private double total;
    private boolean estadoFactura;

    @ManyToOne
    @JoinColumn
    private Usuario usuarioFactura;

    @ManyToOne
    @JoinColumn
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn
    private Cuenta cuentaFactura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturadetalle")
    private List<DetalleFactura> facturadetalle;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedidoFactura")
    private Pedido pedidoFactura;



    public Factura() {
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(boolean estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public Usuario getUsuarioFactura() {
        return usuarioFactura;
    }

    public void setUsuarioFactura(Usuario usuarioFactura) {
        this.usuarioFactura = usuarioFactura;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public List<DetalleFactura> getFacturadetalle() {
        return facturadetalle;
    }

    public void setFacturadetalle(List<DetalleFactura> facturadetalle) {
        this.facturadetalle = facturadetalle;
    }

    public Pedido getPedidoFactura() {
        return pedidoFactura;
    }

    public void setPedidoFactura(Pedido pedidoFactura) {
        this.pedidoFactura = pedidoFactura;
    }





    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Cuenta getCuentaFactura() {
        return cuentaFactura;
    }

    public void setCuentaFactura(Cuenta cuentaFactura) {
        this.cuentaFactura = cuentaFactura;
    }



    @Override
    public String toString() {
        String u = ",usuarioFactura==(null)";
        if (this.usuarioFactura != null) {
            u = ", usuarioFactura=(" + this.usuarioFactura.getCedula() + ")";
        }
        String d = ",tipoPago==(null)";
        if (this.tipoPago != null) {
            d = ", tipoPago=(" + this.tipoPago.getCodigoTipo() + ")";
        }
        String e = ",cuenta==(null)";
        if (this.cuentaFactura != null) {
            e = ", cuenta=(" + this.cuentaFactura.getCodigoCuenta() + ")";
        }
        return "Factura{" + "codigoFactura=" + codigoFactura + ", fechaFactura=" + fechaFactura + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", estadoFactura=" + estadoFactura + u + d + e + ", facturadetalle=" + facturadetalle + ", pedidoFactura=" + pedidoFactura + '}';
    }








}
