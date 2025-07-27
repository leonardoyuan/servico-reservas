package com.leoyuan.servicoreservas.api.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteInput {

    @NotBlank(message = "O nome do restaurante é obrigatório.")
    private String nome;

    @NotBlank(message = "O endereço do restaurante é obrigatório.")
    private String endereco;

    private String telefone;

}