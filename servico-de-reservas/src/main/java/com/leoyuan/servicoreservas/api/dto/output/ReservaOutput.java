package com.leoyuan.servicoreservas.api.dto.output;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaOutput {

    private Long restauranteId;

    private String nomeCliente;

    private String telefoneCliente;

    private Integer quantidadePessoas;

    private Instant dataHora;

}
