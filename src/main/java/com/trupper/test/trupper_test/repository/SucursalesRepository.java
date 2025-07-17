package com.trupper.test.trupper_test.repository;

import com.trupper.test.trupper_test.entity.Sucursal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalesRepository extends CrudRepository<Sucursal,Integer> {
}
