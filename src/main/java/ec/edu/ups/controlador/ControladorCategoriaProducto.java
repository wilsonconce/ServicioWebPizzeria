package ec.edu.ups.controlador;

import ec.edu.ups.entidades.CategoriaProducto;
import ec.edu.ups.servicio.CategoriaProductoServicio;
import ec.edu.ups.servicio.DatoNoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ControladorCategoriaProducto {

    private CategoriaProductoServicio categoriaProductoServicio;

    @Autowired
    public void setCategoriaProductoServicio(CategoriaProductoServicio categoriaProductoServicio) {
        this.categoriaProductoServicio = categoriaProductoServicio;
    }

    @GetMapping("categoriaproducto/{nombre}")
    public ResponseEntity<CategoriaProducto> getCategoriaProductoByNombre(@PathVariable String nombre){
        Optional<CategoriaProducto> categoriaProductoOptional = Optional.ofNullable(categoriaProductoServicio.retriveCategoriaProductoByNombre(nombre));
        CategoriaProducto categoriaProducto = categoriaProductoOptional.orElseThrow(DatoNoEncontrado::new);
        return new ResponseEntity<CategoriaProducto>(categoriaProducto, HttpStatus.OK);
    }

    @GetMapping("categoria/{codigo}")
    public ResponseEntity<String> getCategoriaNombreByCodigo(@PathVariable int codigo){
        String nombre = categoriaProductoServicio.retriveCategoriaProductoNombreByCodigo(codigo);
        return new ResponseEntity<String>(nombre, HttpStatus.OK);
    }

    @GetMapping("/categorias/nombres")
    public ResponseEntity<List<String>> getAllCategoriasNombres(){
        List<String> listaCategoriasNombres = categoriaProductoServicio.retriveAllNombres();
        return new ResponseEntity<List<String>>(listaCategoriasNombres, HttpStatus.OK);
    }


}
