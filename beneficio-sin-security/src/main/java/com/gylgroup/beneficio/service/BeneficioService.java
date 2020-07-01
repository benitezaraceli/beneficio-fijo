package com.gylgroup.beneficio.service;

import com.gylgroup.beneficio.entity.Beneficio;
import com.gylgroup.beneficio.entity.TipoBeneficio;

import java.util.List;

public interface BeneficioService {
    /**US-1:  Alta de  un beneficio fijo*/
    public Beneficio createBeneficio(Beneficio beneficio);
    /**US2:  Cambio de estado de un beneficio fijo [Update]*/
    public Beneficio updateEstadoBeneficio(Beneficio beneficio);
    /**US3:  Modificación de un beneficio fijo [update]*/
    public Beneficio updateBeneficio(Beneficio beneficio);
    /** US4:  Consulta de un beneficio fijo [get]*/
    public Beneficio getBeneficio(Long id);
    /**US5:  Listar beneficios fijos [get all]*/
    public List<Beneficio> listAllBeneficio();
    /**US6:  Baja de un beneficio fijo [delete]*/
    public Beneficio deleteBeneficio(Long id);

    /** encontrar por tipo de veneficio*/
    public List<Beneficio> findByTipoBeneficio(TipoBeneficio tipoBeneficio);
}
