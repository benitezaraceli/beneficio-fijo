package com.gylgroup.beneficio.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
/**
 * @Author pablovass
 * Clase que va el de benefio que tengamos */
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "tbl_beneficio")

public class Beneficio {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
       // private String usuario;
        private String nombre;
        private String descripcion;
        private String campaña;
        @Column(name = "codigo_beneficio")
        private String codigoBeneficio;
        @Column(name = "fecha_alta")
        @Temporal(TemporalType.TIMESTAMP)
        private Date fechaAlta;

        @Column(name = "fecha_expiracion")
        @Temporal(TemporalType.TIMESTAMP)
        private Date fechaExpiracion;
        private String estado;
       // private double montoMinimoTransaccion;
        //private double montoFijoDescuento;
        //private double montoMaximoDescuento;
        //private double porcentajeDescuento;
        //private int cantidadItems;
        //private double presupuesto;
        //private double saldoDisponible;
      // @NotNull(message = "La categoria no puede ser vacia")
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "tipo_beneficio_id")
        @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
        private TipoBeneficio tipoBeneficio;

}

