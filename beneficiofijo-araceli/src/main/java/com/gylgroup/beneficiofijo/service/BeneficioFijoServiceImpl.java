package com.gylgroup.beneficiofijo.service;
/*
 @Author @aldanaabenitez
 Implementación de los servicios de beneficio
*/

import com.gylgroup.beneficiofijo.entity.*;
import com.gylgroup.beneficiofijo.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficioFijoServiceImpl implements BeneficioFijoService {
    @Autowired
    private final BeneficioRepository beneficioRepository;
    @Autowired
    private final BeneficioFijoRepository beneficioFijoRepository;
    @Autowired
    private final AuditoriaRegistroRepository auditoriaRegistroRepository;
    @Autowired
    private final MovimientoSaldoRepository movimientoSaldoRepository;

    @Override
    public List<Beneficio> listAllBeneficios() {
        return beneficioRepository.findAll();
    }

    public Fijo getBeneficioFijo(Long id) {
        return beneficioFijoRepository.findById(id).orElse(null);
    }

    @Override
    public Beneficio getBeneficio(Long id) {
        return beneficioRepository.findById(id).orElse(null);
    }

    @Override
    public Beneficio updateEstado(Long id, String estado) {
        Beneficio beneficioDB = getBeneficio(id);
        if (beneficioDB == null) {
            return null;
        }
        beneficioDB.setEstado_beneficio(estado);
        return beneficioRepository.save(beneficioDB);
    }

    @Override
    public Beneficio createBeneficio(Beneficio beneficio) {
        Beneficio beneficioDB = getBeneficio(beneficio.getId());
        if (beneficioDB != null) {
            return null;
        }
        beneficio.setEstado_beneficio("DISPONIBLE");
        beneficio.setFecha_alta(new Date());

        Fijo beneficioFijo = new Fijo();
        beneficioFijo.setFecha_creacion(beneficio.getFecha_alta());
        beneficioFijo.setFecha_expiracion(beneficio.getFecha_expiracion());
        beneficioFijo.setUsuario(beneficio.getUsuario());
        beneficioFijo.setCodigo_cupon(beneficio.getCodigo());
        beneficioFijoRepository.save(beneficioFijo);

        AuditoriaRegistro registroAlta = new AuditoriaRegistro(beneficioFijo, "DISPONIBLE");
        auditoriaRegistroRepository.save(registroAlta);

        MovimientoSaldo movimientoSaldoAlta = new MovimientoSaldo(beneficio.getUsuario(), beneficio.getFecha_alta(), null, null, beneficio.getPresupuesto());

        return beneficioRepository.save(beneficio);
    }

    @Override
    public Beneficio updateBeneficio(Beneficio beneficio) {
        Beneficio beneficioDB = getBeneficio(beneficio.getId());
        if (beneficioDB == null) {
            return null;
        }
        beneficioDB.setNombre(beneficio.getNombre());
        beneficioDB.setCantidad_items(beneficio.getCantidad_items());
        return beneficioRepository.save(beneficioDB);
    }

    @Override
    public boolean deleteBeneficio(Long id) {
        Beneficio beneficioDB = getBeneficio(id);
        if (beneficioDB == null) {
            return false;
        }
        if (beneficioDB.getEstado_beneficio() != "Borrador" && beneficioDB.getEstado_beneficio() != "Activo" && beneficioDB.getEstado_beneficio() != "Pausado") {
            return false;
        }
        beneficioRepository.deleteById(id);
        return true;
    }
}
