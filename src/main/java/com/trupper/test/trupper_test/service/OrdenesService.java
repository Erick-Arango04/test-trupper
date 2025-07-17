package com.trupper.test.trupper_test.service;

import com.trupper.test.trupper_test.dto.*;
import com.trupper.test.trupper_test.entity.Orden;
import com.trupper.test.trupper_test.entity.Producto;
import com.trupper.test.trupper_test.entity.Sucursal;
import com.trupper.test.trupper_test.exception.OrdenNoExistente;
import com.trupper.test.trupper_test.exception.SucursalNoEncontrada;
import com.trupper.test.trupper_test.repository.OrdenesRepository;
import com.trupper.test.trupper_test.repository.SucursalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrdenesService {

    private final OrdenesRepository ordenesRepository;
    private final SucursalesRepository sucursalesRepository;


    public ResponseEntity<RespuestaGeneralTDO> crearOrden(RequestProductoTDO requestProductoTDO) {

        var sucursal = getSucursal(requestProductoTDO);

        var orden = crearOrdenEntity(requestProductoTDO, sucursal);
        this.ordenesRepository.save(orden);

        var responseOrdenTDO = new ResponseOrdenTDO(sucursal.getNombre(), orden.getId(), requestProductoTDO.productos());
        var response = new RespuestaGeneralTDO(HttpStatus.OK.value(), "Operacion Exitosa", responseOrdenTDO);

        return ResponseEntity.ok(response);
    }


    public ResponseEntity<RespuestaGeneralTDO> obtenerOrden(Integer idOrder) {

        var orden = buscarOrden(idOrder);

        var listProductsTdo = orden.getProductos().stream()
                .map(p ->
                        new ProductosTDO(p.getCodigo(), p.getDescripcion(), p.getPrecio())).toList();

        var orderTdo = new OrdenTDO(
                orden.getId(),
                orden.getSucursal().getNombre(),
                listProductsTdo,
                orden.getTotal()
                ,orden.getFecha());

        var response = new RespuestaGeneralTDO(HttpStatus.OK.value(), "Operacion Exitosa", orderTdo);

        return ResponseEntity.ok(response);

    }



    private Orden crearOrdenEntity(RequestProductoTDO requestProductoTDO, Sucursal sucursal) {

        var listaProductos = requestProductoTDO.productos().stream()
                .map(productosTDO ->
                        Producto.builder()
                                .codigo(productosTDO.codigo())
                                .descripcion(productosTDO.descripcion())
                                .precio(productosTDO.precio()).build())
                .toList();

        var total = listaProductos.stream().mapToDouble(Producto::getPrecio).sum();

        var orden = Orden.builder()
                .fecha(new Date())
                .total(total)
                .sucursal(sucursal)
                .build();

        orden.agregarProductos(listaProductos);

        return orden;
    }


    private Sucursal getSucursal(RequestProductoTDO requestProductoTDO) {
        return sucursalesRepository.findById(requestProductoTDO.sucursal())
                .orElseThrow(() -> new SucursalNoEncontrada("Sucursal No Existente"));
    }

    private Orden buscarOrden(Integer idOrder) {
        return this.ordenesRepository.findById(idOrder)
                .orElseThrow(() -> new OrdenNoExistente("La Orden No Existe"));
    }


}
