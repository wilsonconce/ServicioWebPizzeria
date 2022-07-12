package ec.edu.ups.entidades.peticiones.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EditarCarrito {

    @JsonProperty
    private String nombre;

    @JsonProperty
    private int cantidad;

    @JsonProperty
    private String nombreProduc;

    public String getNombreProduc() {
        return nombreProduc;
    }

    public void setNombreProduc(String nombreProduc) {
        this.nombreProduc = nombreProduc;
    }

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
