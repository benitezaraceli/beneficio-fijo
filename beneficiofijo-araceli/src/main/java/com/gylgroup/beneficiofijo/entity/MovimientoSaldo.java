package com.gylgroup.beneficiofijo.entity;
/*
 @Author @aldanaabenitez
 Mapeo de la entidad MovimientoSaldo
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_movimiento_saldo")
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class MovimientoSaldo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private Double saldo_ejecutado;
    private Double saldo_reservado;
    private Double monto_presupuestado;

    public MovimientoSaldo(String usuario, Date fecha, Double saldo_ejecutado, Double saldo_reservado, Double presupuesto) {
    }
}