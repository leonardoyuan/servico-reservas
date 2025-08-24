package com.leoyuan.servicoreservas.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leoyuan.servicoreservas.api.dto.input.RestauranteInput;
import com.leoyuan.servicoreservas.api.dto.output.RestauranteOutput;
import com.leoyuan.servicoreservas.api.mapper.RestauranteMapper;
import com.leoyuan.servicoreservas.domain.model.Restaurante;
import com.leoyuan.servicoreservas.domain.repository.RestauranteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteMapper restauranteMapper;

    public List<RestauranteOutput> listarRestaurantes() {
        return restauranteRepository.findAll()
                .stream()
                .map(restauranteMapper::toOutput).toList();
    }

    public Optional<RestauranteOutput> buscarRestaurantePorId(Long id) {
        return restauranteRepository.findById(id).map(restauranteMapper::toOutput);
    }

    public RestauranteOutput salvarRestaurante(RestauranteInput restauranteInput) {
        Restaurante restaurante = restauranteMapper.toEntity(restauranteInput);
        Restaurante novo = restauranteRepository.save(restaurante);

        return restauranteMapper.toOutput(novo);
    }

    public RestauranteOutput atualizarDadosDoRestaurante(Long id, RestauranteInput dadosAtualizados) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Esse restaurante nao existe"));

        restaurante.setNome(dadosAtualizados.getNome());
        restaurante.setEndereco(dadosAtualizados.getEndereco());
        restaurante.setTelefone(dadosAtualizados.getTelefone());

        Restaurante atualizado = restauranteRepository.save(restaurante);

        return restauranteMapper.toOutput(atualizado);
    }

    public void deletarRestaurante(Long id) {

        if (restauranteRepository.existsById(id)) {
            restauranteRepository.deleteById(id);

        } else {
            throw new EntityNotFoundException("Esse Restaurante não existe");
        }

    }

}
