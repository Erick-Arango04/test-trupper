package com.trupper.test.trupper_test.controller;

import com.trupper.test.trupper_test.dto.ProductosTDO;
import com.trupper.test.trupper_test.dto.RespuestaGeneralTDO;
import com.trupper.test.trupper_test.service.ProductoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trupper/producto")
@Validated
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PutMapping("{codigo}")
    public ResponseEntity<RespuestaGeneralTDO> actualizarOrdenCompra(@Min(value = 5) @PathVariable String codigo,
                                                                     @Valid @RequestBody ProductosTDO productosTDO) {
        return productoService.actualizarProducto(codigo,productosTDO);
    }

}
