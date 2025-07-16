package com.trupper.test.trupper_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDENES")
public class Ordenes {

    @Id
    private Integer idOrden;
    private Integer idSucursal;
    private Date fecha;
    private Double total;

}
