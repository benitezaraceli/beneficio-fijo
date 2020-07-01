package com.gylgroup.beneficio.repository;

import com.gylgroup.beneficio.entity.Beneficio;
import com.gylgroup.beneficio.entity.TipoBeneficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {

    public List<Beneficio> findByTipoBeneficio(TipoBeneficio tipoBeneficio);
    public Beneficio findByCodigoBeneficio(String codigoBeneficio);

}
