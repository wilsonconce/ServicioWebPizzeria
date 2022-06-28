package ec.edu.ups.entidades;
import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoProducto;

    private String nombre;
    private String descripcion;
    private double precio;
    //private byte imagen;
    private int stock;

    @Transient
    private boolean editable;

    @ManyToOne
    @JoinColumn
    private CategoriaProducto categoria;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto")
    private DetalleFactura detalleFactura;


    @JoinTable(name = "productos_sucursal", joinColumns = {
            @JoinColumn(name = "codigoProducto", referencedColumnName = "codigoProducto")}, inverseJoinColumns = {
            @JoinColumn(name = "codigo_sucursal", referencedColumnName = "codigo")
    })
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Sucursal> listaSucursal = new ArrayList<Sucursal>();

    public Producto(String nombre, String descripcion, double precio, int stock, CategoriaProducto categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        //this.imagen = imagen;
        this.stock = stock;
        this.categoria = categoria;
        listaSucursal = new ArrayList<Sucursal>();
    }

    public Producto() {
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * public byte getImagen() { return imagen; }
     *
     * public void setImagen(byte imagen) { this.imagen = imagen; }
     *
     */
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    public DetalleFactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public List<Sucursal> getListaSucursal() {
        return listaSucursal;
    }

    public void setListaSucursal(List<Sucursal> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }

    public void addProducto(Sucursal su){
        this.listaSucursal.add(su);
    }





    @Override
    public String toString() {
        String u = ",Categoria==(null)";
        if (this.categoria != null) {
            u = ", Categoria=(" + this.categoria.getCodigoCategoria() + ")";
        }
        return "Producto{" + "codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + u + ", detalleFactura=" + detalleFactura + '}';
    }

}
