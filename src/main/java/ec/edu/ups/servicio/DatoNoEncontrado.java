package ec.edu.ups.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="Dato no encontrado")
public class DatoNoEncontrado extends RuntimeException{

    public DatoNoEncontrado(){
    }

    public DatoNoEncontrado(String message){
        super(message);
    }
}
