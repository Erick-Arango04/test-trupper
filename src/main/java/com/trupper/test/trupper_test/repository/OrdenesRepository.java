package com.trupper.test.trupper_test.repository;

import com.trupper.test.trupper_test.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenesRepository extends JpaRepository<Orden, Integer> {

}
