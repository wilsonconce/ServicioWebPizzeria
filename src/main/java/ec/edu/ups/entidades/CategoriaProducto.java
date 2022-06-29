package ec.edu.ups.entidades;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author johan
 */
@Entity

public class CategoriaProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoCategoria;
    private String nombre;
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Producto> productos;

    public CategoriaProducto() {
    }

    public CategoriaProducto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaProducto categoriaProducto = (CategoriaProducto) o;
        return codigoCategoria == categoriaProducto.codigoCategoria && Objects.equals(nombre, categoriaProducto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCategoria, nombre);
    }


    @Override
    public String toString() {
        String u = ",sucursalCategoria==(null)";

        String d = ", productos=(null)";
        if (this.productos != null) {
            d = ", producto=" + this.productos.toString() + ")";
        }
        return "CategoriaSucursal{" + "codigoCategoria=" + codigoCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + u + d + '}';
    }
}
