package com.trupper.test.trupper_test.dto;

import java.util.Date;
import java.util.List;

public record OrdenTDO (Integer idOrden, String sucursal, List<ProductosTDO> productos, Double total, Date fecha) {
}
