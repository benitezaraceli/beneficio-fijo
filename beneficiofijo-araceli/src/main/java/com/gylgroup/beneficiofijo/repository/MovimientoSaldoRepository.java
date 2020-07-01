package com.gylgroup.beneficiofijo.repository;
/*
 @Author @aldanaabenitez
 Repositorio de Beneficio Fijo
*/
import com.gylgroup.beneficiofijo.entity.MovimientoSaldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoSaldoRepository extends JpaRepository<MovimientoSaldo, Long> {
}