package com.gylgroup.beneficiofijo.repository;
/*
 @Author @aldanaabenitez
 Repositorio de Beneficio Fijo
*/
import com.gylgroup.beneficiofijo.entity.Fijo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeneficioFijoRepository extends JpaRepository<Fijo, Long> {
    Optional<Fijo> findById(Long id);
}