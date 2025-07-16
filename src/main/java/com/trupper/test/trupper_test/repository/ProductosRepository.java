package com.trupper.test.trupper_test.repository;

import com.trupper.test.trupper_test.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductosRepository extends JpaRepository<Productos,Integer> {

    Optional<Productos> findByCodigo(String codigo);
}
