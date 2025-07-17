package com.trupper.test.trupper_test;

import com.trupper.test.trupper_test.entity.Sucursal;
import com.trupper.test.trupper_test.repository.SucursalesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class TrupperTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TrupperTestApplication.class, args);
	}

	private final SucursalesRepository sucursalesRepository;

	@Override
	public void run(String... args) throws Exception {

		var sucursal = Sucursal.builder().nombre("CDMX").build();
		this.sucursalesRepository.save(sucursal);

		log.info("INSERCION DE SUCURSAL EXITOSA", sucursal);
	}
}
