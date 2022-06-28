package ec.edu.ups.entidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author johan
 */
@Entity
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTipo;

    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario")
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public TipoUsuario() {
    }





    public TipoUsuario(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public String toString() {
        String d = ", usuarios=(null)";
        if (this.usuarios != null) {
            d = ", usuarios=" + this.usuarios.toString() + ")";
        }
        return "TipoUsuario{" + "idTipo=" + idTipo + ", descripcion=" + descripcion +d+ '}';
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + Objects.hashCode(this.usuarios);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoUsuario other = (TipoUsuario) obj;
        return true;
    }



}
