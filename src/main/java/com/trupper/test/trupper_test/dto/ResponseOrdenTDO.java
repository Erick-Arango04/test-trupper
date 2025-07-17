package com.trupper.test.trupper_test.dto;

import java.util.List;

public record ResponseOrdenTDO (String sucursal, Integer idOrden, List<ProductosTDO> productos){
}
