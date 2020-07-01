package com.gylgroup.beneficiofijo.repository;
/*
 @Author @aldanaabenitez
 Repositorio de Beneficio
*/
import com.gylgroup.beneficiofijo.entity.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {

    Optional<Beneficio> findById(Long id);
}