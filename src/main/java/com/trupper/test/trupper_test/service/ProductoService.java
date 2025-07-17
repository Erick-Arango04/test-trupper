package com.trupper.test.trupper_test.service;

import com.trupper.test.trupper_test.dto.ProductosTDO;
import com.trupper.test.trupper_test.dto.RespuestaGeneralTDO;
import com.trupper.test.trupper_test.exception.ProductoNoEncontrado;
import com.trupper.test.trupper_test.repository.ProductosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductosRepository productosRepository;


    public ResponseEntity<RespuestaGeneralTDO> actualizarProducto (String codigo, ProductosTDO productosTDO) {

        var product = this.productosRepository.findByCodigo(codigo)
                .orElseThrow(() -> new ProductoNoEncontrado("Producto no encontrado"));

        product.setCodigo(productosTDO.codigo());
        product.setDescripcion(productosTDO.descripcion());
        product.setPrecio(productosTDO.precio());

        this.productosRepository.save(product);
        var response = new RespuestaGeneralTDO(HttpStatus.OK.value(), "Operacion Exitosa", productosTDO);

        return ResponseEntity.ok(response);
    }

}
