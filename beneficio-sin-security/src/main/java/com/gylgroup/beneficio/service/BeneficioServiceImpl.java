package com.gylgroup.beneficio.service;

import com.gylgroup.beneficio.entity.Beneficio;
import com.gylgroup.beneficio.entity.TipoBeneficio;
import com.gylgroup.beneficio.repository.BeneficioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * @Author Pablovass
 * Clase que implementa los metodos de la interface beneficioRepository
 */
@Service
@RequiredArgsConstructor
public class BeneficioServiceImpl implements  BeneficioService{

    private  final BeneficioRepository beneficioRepository;

    @Override
    public Beneficio createBeneficio(Beneficio beneficio) {
        Beneficio beneficioDB = beneficioRepository.findByCodigoBeneficio(beneficio.getCodigoBeneficio());
        if (beneficioDB !=null){
            return beneficioDB;
        }
        //beneficio.setFechaAlta(new Date());
        //beneficio.setFechaExpiracion(new Date());
        beneficio.setEstado("Create");
        return beneficioRepository.save(beneficio);

    }

    @Override
    public Beneficio updateEstadoBeneficio(Beneficio beneficio) {
        Beneficio beneficioDB = getBeneficio(beneficio.getId());
        if (null == beneficioDB) {
            return null;
        }
        //setear los datos que queres actualizar
        beneficioDB.setNombre(beneficio.getNombre());
        return beneficioRepository.save(beneficioDB);
    }
    @Override
    public Beneficio updateBeneficio(Beneficio beneficio) {
        Beneficio beneficioDB=getBeneficio(beneficio.getId());
        if(null==beneficioDB){
            return null;
        }
        //setear los datos que queres actualizar
        beneficioDB.setNombre(beneficio.getNombre());
        return beneficioRepository.save(beneficioDB);
    }

    @Override
    public Beneficio getBeneficio(Long id) {
        return beneficioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Beneficio> listAllBeneficio() {
        return beneficioRepository.findAll();
    }

    @Override
    public Beneficio deleteBeneficio(Long id) {
        Beneficio beneficioDB=getBeneficio(id);
        if(null==beneficioDB){
            return null;
        }
        beneficioDB.setEstado("Deleted");
        return beneficioRepository.save(beneficioDB);
    }
    @Override
    public List<Beneficio> findByTipoBeneficio(TipoBeneficio tipoBeneficio){
        return beneficioRepository.findByTipoBeneficio(tipoBeneficio);
    }
}
