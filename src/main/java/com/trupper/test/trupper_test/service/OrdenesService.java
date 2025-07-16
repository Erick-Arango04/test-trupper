package com.trupper.test.trupper_test.service;

import com.trupper.test.trupper_test.dto.ProductosTDO;
import com.trupper.test.trupper_test.dto.RequestProductoTDO;
import com.trupper.test.trupper_test.dto.RespuestaGeneral;
import com.trupper.test.trupper_test.entity.Productos;
import com.trupper.test.trupper_test.exception.ProductoNoEncontrado;
import com.trupper.test.trupper_test.repository.OrdenesRepository;
import com.trupper.test.trupper_test.repository.ProductosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrdenesService {

    private final OrdenesRepository ordenesRepository;
    private final ProductosRepository productosRepository;

    public OrdenesService(OrdenesRepository ordenesRepository, ProductosRepository productosRepository) {
        this.ordenesRepository = ordenesRepository;
        this.productosRepository = productosRepository;
    }

    public ResponseEntity<RespuestaGeneral> crearOrden(RequestProductoTDO requestProductoTDO) {

        var listProducts = requestProductoTDO.productos().stream().map(productosTDO -> new Productos
                (null, requestProductoTDO.ordenId(),
                        productosTDO.codigo(), productosTDO.descripcion(), productosTDO.precio())).toList();


        productosRepository.saveAll(listProducts);


        return ResponseEntity.ok(null);
    }



    public ResponseEntity<RespuestaGeneral> obtenerOrden(Integer idOrder) {

      return null;

    }


    public ResponseEntity<RespuestaGeneral> actualizarOrden(String codigo, ProductosTDO productosTDO) {

       var product = this.productosRepository.findByCodigo(codigo)
               .orElseThrow(() -> new ProductoNoEncontrado("Producto no encontrado"));

       product.setCodigo(productosTDO.codigo());
       product.setDescripcion(productosTDO.descripcion());
       product.setPrecio(productosTDO.precio());

       this.productosRepository.save(product);
        var response = new RespuestaGeneral(HttpStatus.OK.value(),"Operacion Exitosa",product);

        return ResponseEntity.ok(response);

    }

}
