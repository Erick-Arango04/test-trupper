package com.trupper.test.trupper_test.dto;

import lombok.NonNull;

import java.util.List;

public record RequestProductoTDO(@NonNull Integer ordenId, @NonNull List<ProductosTDO> productos) {
}
