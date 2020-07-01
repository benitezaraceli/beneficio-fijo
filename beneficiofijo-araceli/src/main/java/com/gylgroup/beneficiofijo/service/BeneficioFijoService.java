package com.gylgroup.beneficiofijo.service;
/*
 @Author @aldanaabenitez
 Interfase de los servicios de beneficio
*/

import com.gylgroup.beneficiofijo.entity.Beneficio;

import java.util.List;

public interface BeneficioFijoService {
    List<Beneficio>listAllBeneficios();
    Beneficio getBeneficio(Long id);
    Beneficio updateEstado(Long id, String estado);
    Beneficio createBeneficio(Beneficio beneficio);
    Beneficio updateBeneficio(Beneficio beneficio);
    boolean deleteBeneficio(Long id);
}
