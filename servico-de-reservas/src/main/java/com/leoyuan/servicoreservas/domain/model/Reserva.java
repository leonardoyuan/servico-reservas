package com.leoyuan.servicoreservas.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Restaurante restaurante;

    private String nomeCliente;

    private String telefoneCliente;

    private Integer quantidadePessoas;

    private Instant dataHora;

}
