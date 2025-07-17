package com.trupper.test.trupper_test.repository;

import com.trupper.test.trupper_test.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductosRepository extends JpaRepository<Producto,Integer> {

    Optional<Producto> findByCodigo(String codigo);
}
