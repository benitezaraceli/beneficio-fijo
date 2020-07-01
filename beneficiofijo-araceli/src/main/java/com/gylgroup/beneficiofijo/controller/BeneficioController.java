package com.gylgroup.beneficiofijo.controller;
/*
 @Author @aldanaabenitez
 Api de Beneficio
*/
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gylgroup.beneficiofijo.entity.Beneficio;
import com.gylgroup.beneficiofijo.service.BeneficioFijoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/beneficios")
@Api(tags = "beneficios")
public class BeneficioController {

    @Autowired
    private BeneficioFijoService beneficioFijoService;

    @GetMapping
    @ApiOperation(value = "Listar Beneficios", notes = "Servicio para ver todos los beneficios")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Beneficios listados correctamente"),
            @ApiResponse(code = 400, message = "Solicitud Inválida"),
            @ApiResponse(code = 204, message = "No hay beneficios")})
    public ResponseEntity<List<Beneficio>> listBeneficios() {
        List<Beneficio> beneficiosDB = beneficioFijoService.listAllBeneficios();
        if (beneficiosDB.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(beneficiosDB);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Mostrar Beneficio", notes = "Servicio para ver un beneficio")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Beneficio listado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud Inválida"),
            @ApiResponse(code = 404, message = "No existe un beneficio con esa ID")})
    public ResponseEntity<Beneficio> getBeneficio(@PathVariable("id") Long id) {
        Beneficio beneficioDB = beneficioFijoService.getBeneficio(id);
        if (beneficioDB==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(beneficioDB);
    }

    @PostMapping
    @ApiOperation(value = "Crear Beneficio", notes = "Servicio para crear un beneficio")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Beneficio creado correctamente"),
            @ApiResponse(code = 400, message = "Ya existe un beneficio con ese ID")})
    public ResponseEntity<Beneficio> createBeneficio(@Valid @RequestBody Beneficio beneficio, BindingResult result) {
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Beneficio beneficioCreate = beneficioFijoService.createBeneficio(beneficio);
        if(beneficioCreate == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(beneficioCreate);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Modificar Beneficio", notes = "Servicio para modificar un beneficio")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Beneficio modificado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud Inválida"),
            @ApiResponse(code = 404, message = "No existe un beneficio con esa ID")})
    public ResponseEntity<Beneficio> updateBeneficio(@PathVariable("id") Long id,@RequestBody Beneficio beneficio) {
        beneficio.setId(id);
        Beneficio beneficioDB = beneficioFijoService.updateBeneficio(beneficio);
        if (beneficioDB==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(beneficioDB);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Eliminar Beneficio", notes = "Servicio para eliminar un beneficio")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "Beneficio eliminado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud Inválida")})
    public ResponseEntity deleteBeneficio(@PathVariable("id") Long id) {
        boolean beneficioDelete = beneficioFijoService.deleteBeneficio(id);
        if (beneficioDelete==false) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/{estado}")
    @ApiOperation(value = "Modificar Estado", notes = "Servicio para modificar un estado")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Estado modificado correctamente"),
            @ApiResponse(code = 400, message = "Solicitud Inválida"),
            @ApiResponse(code = 404, message = "No existe un beneficio con esa ID")})
    public ResponseEntity<Beneficio> updateEstado(@PathVariable("id") Long id,@RequestParam(name = "estado", required = true) String estado) {
        Beneficio beneficioDB = beneficioFijoService.updateEstado(id, estado);
        if (beneficioDB==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(beneficioDB);
    }

    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map (err ->{
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
        }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();
        ObjectMapper mapper = new ObjectMapper();
                String jsonString = "";
        try{
            jsonString = mapper.writeValueAsString(errorMessage);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return jsonString;
    }
}
