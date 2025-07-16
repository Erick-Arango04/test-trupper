package com.trupper.test.trupper_test.exception;

import com.trupper.test.trupper_test.dto.RespuestaGeneral;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(ProductoNoEncontrado.class)
    public ResponseEntity<RespuestaGeneral> handleConflict(ProductoNoEncontrado productoNoEncontrado) {

        final var codigoHhtp = 404;
        final var response = new RespuestaGeneral(codigoHhtp, "Ocurrio un error", productoNoEncontrado.getMessage());
        return ResponseEntity.status(codigoHhtp).body(response);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RespuestaGeneral> handleConflict(ConstraintViolationException ex) {

        final var codigoHhtp = 400;

        var error = new StringBuilder();

        var errorMessage = ex.getConstraintViolations().stream()
                .map(violation -> {
                            error.append(violation.getPropertyPath());
                            error.append(":");
                            error.append(violation.getMessage());
                            return error;
                        }
                )
                .collect(Collectors.joining(","));

        final var response = new RespuestaGeneral(codigoHhtp, "Ocurrio un error", errorMessage);
        return ResponseEntity.status(codigoHhtp).body(response);
    }


}
