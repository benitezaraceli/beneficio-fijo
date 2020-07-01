package com.gylgroup.beneficio.entity;

import javax.persistence.*;
import  lombok.*;
/**
 * @Author pablovass
 * Clase que va a definir el tipo de benefio que tengamos */
@Entity
@Table(name="tipo_beneficio")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TipoBeneficio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

}
