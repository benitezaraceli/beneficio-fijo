package com.gylgroup.beneficiofijo.entity;
/*
 @Author @aldanaabenitez
 Mapeo de la entidad Fijo
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="tbl_fijo")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Fijo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_creacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_expiracion;
    private int secuencia;
    private String codigo_cupon;
    private String estado;
    private UUID token;
    private Double monto_descuento;


}
