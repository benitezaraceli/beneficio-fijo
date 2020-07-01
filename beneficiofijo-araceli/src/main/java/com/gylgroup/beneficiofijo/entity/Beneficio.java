package com.gylgroup.beneficiofijo.entity;
/*
 @Author @aldanaabenitez
 Mapeo de la entidad Beneficio
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_beneficio")
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class Beneficio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String usuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_alta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_expiracion;
    private String codigo;
    private String tipo_beneficio;
    private String campania;
    private int cantidad_items;
    private String estado_beneficio;
    private Double monto_minimo_transaccion;
    private Double monto_descuento;
    private Double porcentaje_descuento;
    private Double saldo_disponible;
    private Double monto_maximo;
    private Double presupuesto;
}
