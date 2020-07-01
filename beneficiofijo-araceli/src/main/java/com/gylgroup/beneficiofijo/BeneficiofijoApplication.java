package com.gylgroup.beneficiofijo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BeneficiofijoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiofijoApplication.class, args);
	}

}