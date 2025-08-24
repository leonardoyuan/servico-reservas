package com.leoyuan.servicoreservas.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoyuan.servicoreservas.api.dto.input.ReservaInput;
import com.leoyuan.servicoreservas.api.dto.output.ReservaOutput;
import com.leoyuan.servicoreservas.api.mapper.ReservaMapper;
import com.leoyuan.servicoreservas.domain.model.Reserva;
import com.leoyuan.servicoreservas.domain.model.Restaurante;
import com.leoyuan.servicoreservas.domain.repository.ReservaRepository;
import com.leoyuan.servicoreservas.domain.repository.RestauranteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    public List<ReservaOutput> listarReservas() {
        return reservaRepository.findAll()
                .stream()
                .map(reservaMapper::toOutput)
                .toList();
    }

    public Optional<ReservaOutput> buscarReservaPorId(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::toOutput);
    }

    public ReservaOutput salvarReserva(ReservaInput reservaInput) {

        Long restauranteId = reservaInput.getRestauranteId();

        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado"));

        Reserva reserva = reservaMapper.toEntity(reservaInput);
        reserva.setRestaurante(restaurante);

        Reserva nova = reservaRepository.save(reserva);
        return reservaMapper.toOutput(nova);
    }

    public ReservaOutput atualizarReserva(Long id, ReservaInput dadosAtualizados) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));

        Restaurante restaurante = restauranteRepository.findById(dadosAtualizados.getRestauranteId())
                .orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado"));

        reserva.setRestaurante(restaurante);
        reserva.setNomeCliente(dadosAtualizados.getNomeCliente());
        reserva.setTelefoneCliente(dadosAtualizados.getTelefoneCliente());
        reserva.setQuantidadePessoas(dadosAtualizados.getQuantidadePessoas());
        reserva.setDataHora(dadosAtualizados.getDataHora());

        Reserva atualizada = reservaRepository.save(reserva);
        return reservaMapper.toOutput(atualizada);
    }

    public void deletarReserva(Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Reserva não encontrada");
        }
    }
}
