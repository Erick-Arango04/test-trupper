package com.trupper.test.trupper_test.controller;


import com.trupper.test.trupper_test.dto.RequestProductoTDO;
import com.trupper.test.trupper_test.dto.RespuestaGeneralTDO;
import com.trupper.test.trupper_test.service.OrdenesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trupper/orden")
@Validated
@RequiredArgsConstructor
public class OrdenesController {

    private final OrdenesService ordenesService;

    @PostMapping()
    public ResponseEntity<RespuestaGeneralTDO> crearOrdenCompra(@Valid @RequestBody RequestProductoTDO requestProductoTDO) {
        return ordenesService.crearOrden(requestProductoTDO);
    }

    @GetMapping("{idOrder}")
    public ResponseEntity<RespuestaGeneralTDO> consultarOrdenCompra(
            @Min (value = 1) @PathVariable Integer idOrder) {
        return ordenesService.obtenerOrden(idOrder);
    }


}
