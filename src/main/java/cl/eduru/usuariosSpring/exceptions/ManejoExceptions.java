package cl.eduru.usuariosSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ManejoExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Object> handleMyException() {
        // Crear objeto JSON con detalles de la excepción
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Email Invalido");
        response.put("codigo", "ONB010");
        // Devolver respuesta con código de estado 500 (Internal Server Error) y objeto JSON
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PassException.class)
    public ResponseEntity<Object> handleExceptionPass() {
        // Crear objeto JSON con detalles de la excepción
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "Por favor validar que la password contenga al menos una letra mayúscula, una letra minúscula, un número y tenga una longitud de entre 8 y 16 caracteres");
        response.put("codigo", "ONB010");
        // Devolver respuesta con código de estado 500 (Internal Server Error) y objeto JSON
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        // Crear objeto JSON con detalles de la excepción
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", ex.getMessage());
        response.put("codigo", "ONB010");

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
