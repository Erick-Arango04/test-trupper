package com.trupper.test.trupper_test.exception;

import com.trupper.test.trupper_test.dto.RespuestaGeneralTDO;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class AllExceptionHandler {

    @ExceptionHandler(ProductoNoEncontrado.class)
    public ResponseEntity<RespuestaGeneralTDO> handleConflict(ProductoNoEncontrado exception) {

        final var codigoHhtp = 404;
        final var response = new RespuestaGeneralTDO(codigoHhtp, "Ocurrio un error", exception.getMessage());

        log.error(exception.getMessage());

        return ResponseEntity.status(codigoHhtp).body(response);
    }


    @ExceptionHandler(SucursalNoEncontrada.class)
    public ResponseEntity<RespuestaGeneralTDO> handleConflict(SucursalNoEncontrada exception) {

        final var codigoHhtp = 404;
        final var response = new RespuestaGeneralTDO(codigoHhtp, "Ocurrio un error", exception.getMessage());
        log.error(exception.getMessage());

        return ResponseEntity.status(codigoHhtp).body(response);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<RespuestaGeneralTDO> handleConflict(UnexpectedTypeException exception) {

        final var codigoHhtp = 400;
        final var response = new RespuestaGeneralTDO(codigoHhtp, "Ocurrio un error", "Valida tu solicitud");
        log.error(exception.getMessage());

        return ResponseEntity.status(codigoHhtp).body(response);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespuestaGeneralTDO> handleConflict(MethodArgumentNotValidException exception) {

        final var codigoHhtp = 400;
        final var response = new RespuestaGeneralTDO(codigoHhtp, "Ocurrio un error", "Valida tu solicitud");
        log.error(exception.getMessage());

        return ResponseEntity.status(codigoHhtp).body(response);
    }

    @ExceptionHandler(OrdenNoExistente.class)
    public ResponseEntity<RespuestaGeneralTDO> handleConflict(OrdenNoExistente exception) {

        final var codigoHhtp = 404;
        final var response = new RespuestaGeneralTDO(codigoHhtp, "Ocurrio un error", exception.getMessage());
        log.error(exception.getMessage());

        return ResponseEntity.status(codigoHhtp).body(response);
    }

    @ExceptionHandler(UsuarioNoencontrado.class)
    public ResponseEntity<RespuestaGeneralTDO> handleConflict(UsuarioNoencontrado exception) {

        final var codigoHhtp = 404;
        final var response = new RespuestaGeneralTDO(codigoHhtp, "Ocurrio un error", exception.getMessage());
        log.error(exception.getMessage());

        return ResponseEntity.status(codigoHhtp).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaGeneralTDO> handleConflict(Exception exception) {

        final var codigoHhtp = 500;
        final var response = new RespuestaGeneralTDO(codigoHhtp, "Ocurrio un error", "Error");
        log.error(exception.getMessage());

        return ResponseEntity.status(codigoHhtp).body(response);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RespuestaGeneralTDO> handleConflict(ConstraintViolationException exception) {

        final var codigoHhtp = 400;
        var error = new StringBuilder();

        var errorMessage = exception.getConstraintViolations().stream()
                .map(violation -> {
                            error.append(violation.getPropertyPath());
                            error.append(":");
                            error.append(violation.getMessage());
                            return error;
                        }
                )
                .collect(Collectors.joining(","));
        log.error(exception.getMessage());
        final var response = new RespuestaGeneralTDO(codigoHhtp, "Ocurrio un error", errorMessage);
        return ResponseEntity.status(codigoHhtp).body(response);
    }


}
