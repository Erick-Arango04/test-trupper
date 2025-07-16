package com.trupper.test.trupper_test.controller;


import com.trupper.test.trupper_test.dto.ProductosTDO;
import com.trupper.test.trupper_test.dto.RequestProductoTDO;
import com.trupper.test.trupper_test.dto.RespuestaGeneral;
import com.trupper.test.trupper_test.service.OrdenesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trupper")
@Validated
public class OrdenesController {

    private final OrdenesService ordenesService;

    public OrdenesController(OrdenesService ordenesService) {
        this.ordenesService = ordenesService;
    }

    @PostMapping()
    public ResponseEntity<RespuestaGeneral> crearOrdenCompra(@Valid @RequestBody RequestProductoTDO requestProductoTDO) {
        return ordenesService.crearOrden(requestProductoTDO);
    }

    @GetMapping("{id}")
    public ResponseEntity<RespuestaGeneral> consultarOrdenCompra(@PathVariable Integer id) {
        return ordenesService.obtenerOrden(id);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<RespuestaGeneral> actualizarOrdenCompra(@Min(value = 5) @PathVariable String codigo,
                                                   @Valid @RequestBody ProductosTDO productosTDO) {
        return ordenesService.actualizarOrden(codigo,productosTDO);
    }

}
