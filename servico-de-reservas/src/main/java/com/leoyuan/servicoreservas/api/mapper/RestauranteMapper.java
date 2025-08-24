package com.leoyuan.servicoreservas.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leoyuan.servicoreservas.api.dto.input.RestauranteInput;
import com.leoyuan.servicoreservas.api.dto.output.RestauranteOutput;
import com.leoyuan.servicoreservas.domain.model.Restaurante;

@Component
public class RestauranteMapper {

    @Autowired
    private ModelMapper modelMapper;

    // transforma Input em Restaurante
    public Restaurante toEntity(RestauranteInput restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }

    // transforma Restaurante em Output
    public RestauranteOutput toOutput(Restaurante restaurante) {
        return modelMapper.map(restaurante, RestauranteOutput.class);
    }

}
