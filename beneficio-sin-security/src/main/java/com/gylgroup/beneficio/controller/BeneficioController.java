package com.gylgroup.beneficio.controller;

import java.util.ArrayList;
import java.util.List;

import com.gylgroup.beneficio.entity.Beneficio;
import com.gylgroup.beneficio.entity.TipoBeneficio;
import com.gylgroup.beneficio.service.BeneficioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/beneficios")
@Api(tags = "beneficio")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class BeneficioController {
    @Autowired
    private BeneficioService beneficioService;

    /**
     * obtiene segun el estado del beneficio
     */
    @GetMapping(value = "")
    @ApiOperation(value = "Obtiene beneficio", notes = "Obtiene segun estado beneficio")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Beneficio Obtenido correctamente"),
            @ApiResponse(code = 404, message = "Solisitud invalida") })
    public ResponseEntity<List<Beneficio>> listBeneficio(
            @RequestParam(name = "tipoBeneficioId", required = false) Long tipoBeneficioId) {
        List<Beneficio> beneficios = new ArrayList<>();
        if (null == tipoBeneficioId) {
            beneficios = beneficioService.listAllBeneficio();
            if (beneficios.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            beneficios = beneficioService.findByTipoBeneficio(TipoBeneficio.builder().id(tipoBeneficioId).build());
            if (beneficios.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(beneficios);

    }

    /** obtiene segun el id del beneficio */
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Obtiene beneficio", notes = "Obtiene segun segun el id del beneficio")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Beneficio Obtenido correctamente"),
            @ApiResponse(code = 400, message = "Solisitud invalida") })
    public ResponseEntity<Beneficio> getBeneficio(@PathVariable Long id) {
        Beneficio beneficio = beneficioService.getBeneficio(id);
        if (null == beneficio) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(beneficio);
    }

    /** inserta un beneficio nuevo */
    @PostMapping("")
    @ApiOperation(value = "Crea un beneficio", notes = "Crea un beneficio")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Crea el beneficio correctamente"),
            @ApiResponse(code = 400, message = "Solicitud invalida") })
    public ResponseEntity<Beneficio> CreateBeneficio(@RequestBody Beneficio beneficio) {
        Beneficio beneficioCreate = beneficioService.createBeneficio(beneficio);
        return ResponseEntity.status(HttpStatus.CREATED).body(beneficioCreate);
    }

    /** actualiza el beneficio */
    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Actualiza el beneficio beneficio", notes = "Actualiza el beneficio segun el dato seteado")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Beneficio actualizado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud invalida") })
    public ResponseEntity<Beneficio> updateBeneficio(@PathVariable("id") Long id, @RequestBody Beneficio beneficio) {
        beneficio.setId(id);
        Beneficio beneficioDB = beneficioService.updateBeneficio(beneficio);
        if (beneficioDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(beneficioDB);
    }

    /** borrar un beneficio */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Borrar beneficio", notes = "Borra el beneficio segun por el estado DELETE")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Beneficio borrado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud invalida") })
    public ResponseEntity<Beneficio> deleteBeneficio(@PathVariable("id") Long id) {
        Beneficio beneficioDelete = beneficioService.deleteBeneficio(id);
        if (beneficioDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(beneficioDelete);
    }

}
