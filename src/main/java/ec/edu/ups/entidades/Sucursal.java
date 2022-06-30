package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author johan
 */
@Entity
public class Sucursal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nombre;
    private String direccion;
    private double latencia;
    private double longitud;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "sucursal")
    private List<Pedido> pedido = new ArrayList<Pedido>();

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listaSucursal", cascade = CascadeType.ALL)
    private List<Producto> listaProductos;

    public Sucursal() {
    }

    public Sucursal(String nombre, String direccion, double latencia, double longitud) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.latencia = latencia;
        this.longitud = longitud;
        listaProductos = new ArrayList<Producto>();
    }

    public void addSucursal(Producto p){
        this.listaProductos.add(p);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLatencia() {
        return latencia;
    }

    public void setLatencia(double latencia) {
        this.latencia = latencia;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        String d = ", categoriaSucursal=(null)";
        if (this.listaProductos != null) {
            d = ", categoriaSucursal=" + this.listaProductos.toString() + ")";
        }
        return "Sucursal{" + "codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", latencia=" + latencia + ", longitud=" + longitud + ", pedido=" + pedido + d+ '}';
    }






}

