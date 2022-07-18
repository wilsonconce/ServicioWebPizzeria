package ec.edu.ups.entidades;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 * @author johan
 */
@Entity
public class Cuenta implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoCuenta;

    private String correo;
    private String contrasena;


    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")

    private List<TarjetaCredito> tarjetaC = new ArrayList<TarjetaCredito>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cuentaPedido")
    @JsonIgnore
    private List<Pedido> pedido = new ArrayList<Pedido>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentaFactura")
    @JsonIgnore
    private List<Factura> factura = new ArrayList<Factura>();

    public Cuenta() {
        this("", "", null);
    }

    public Cuenta(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Cuenta(String correo, String contrasena, Usuario usuario) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.usuario = usuario;
    }
    public void addPedido(Pedido p){
        this.pedido.add(p);
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public List<TarjetaCredito> getTarjetaC() {
        return tarjetaC;
    }

    public void setTarjetaC(List<TarjetaCredito> tarjetaC) {
        this.tarjetaC = tarjetaC;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }




    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }


    @Override
    public String toString() {
        String u = ",usuario=(null)";
        String p = ", pedido=(null)";
        String a=", tarjetaC=(null)";
        if (this.pedido != null) {
            p = ", pedido=" + this.pedido.toString() + ")";
        }
        if (this.usuario != null) {
            u = ",UsuarioId=(" + this.usuario.getCedula() + ")";
        }
        if (this.usuario != null) {
            a = ",tarjetaC=(" + this.tarjetaC.toString() + ")";
        }
        return "Cuenta{" + "correo=" + correo + ", contrasena=" + contrasena + u +
                a + p + '}';
    }


}
