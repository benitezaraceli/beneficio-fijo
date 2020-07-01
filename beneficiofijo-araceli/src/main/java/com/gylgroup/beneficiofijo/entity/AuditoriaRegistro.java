package com.gylgroup.beneficiofijo.entity;
/*
 @Author @aldanaabenitez
 Mapeo de la entidad AuditoriaRegistro
*/
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_auditoria_registro")
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class AuditoriaRegistro {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "El beneficio fijo no puede estar vacío")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fijo fijo;
    private String estado_beneficio;

    public AuditoriaRegistro(Fijo fijo, String estado_beneficio) {
        this.fijo = fijo;
        this.estado_beneficio = estado_beneficio;
    }
}