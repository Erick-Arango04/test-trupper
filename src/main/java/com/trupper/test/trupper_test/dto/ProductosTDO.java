package com.trupper.test.trupper_test.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

public record ProductosTDO (
        @NonNull
        @NotEmpty String codigo,

        @NonNull
        @NotEmpty String descripcion,

        @NonNull Double precio){
}
