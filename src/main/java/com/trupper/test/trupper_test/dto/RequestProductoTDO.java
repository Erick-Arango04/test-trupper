package com.trupper.test.trupper_test.dto;


import jakarta.validation.Valid;
import lombok.NonNull;

import java.util.List;


public record RequestProductoTDO(@NonNull Integer sucursal, @Valid List<ProductosTDO> productos) {
}
