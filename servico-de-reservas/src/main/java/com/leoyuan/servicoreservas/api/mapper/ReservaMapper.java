package com.leoyuan.servicoreservas.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leoyuan.servicoreservas.api.dto.input.ReservaInput;
import com.leoyuan.servicoreservas.api.dto.output.ReservaOutput;
import com.leoyuan.servicoreservas.domain.model.Reserva;

@Component
public class ReservaMapper {

    @Autowired
    private ModelMapper modelMapper;

    //transforma Input em Reserva
    public Reserva toEntity(ReservaInput reservaInput) {
        return modelMapper.map(reservaInput, Reserva.class);
    }

    //transforma Reserva em Output
    public ReservaOutput toOutput(Reserva reserva) {
        return modelMapper.map(reserva, ReservaOutput.class);
    }

}
