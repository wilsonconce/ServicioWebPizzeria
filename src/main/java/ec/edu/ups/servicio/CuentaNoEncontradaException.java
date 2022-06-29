package ec.edu.ups.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Cuenta no encontrada!")
public class CuentaNoEncontradaException extends RuntimeException{
    public CuentaNoEncontradaException() {
    }

    public CuentaNoEncontradaException(String message) {
        super(message);
    }
}
