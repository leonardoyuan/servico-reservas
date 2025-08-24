package com.leoyuan.servicoreservas.api.dto.input;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaInput {

    private Long restauranteId;

    private String nomeCliente;

    private String telefoneCliente;

    private Integer quantidadePessoas;

    private Instant dataHora;

}
