package com.leoyuan.servicoreservas.domain.service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.leoyuan.servicoreservas.domain.model.Restaurante;
import com.leoyuan.servicoreservas.domain.repository.RestauranteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> buscarRestaurantePorId(Long id) {
        return restauranteRepository.findById(id);
    }

    public Restaurante salvarRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Restaurante atualizarDadosDoRestaurante(Long id, Restaurante dadosAtualizados) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Esse restaurante nao existe"));

        restaurante.setNome(dadosAtualizados.getNome());
        restaurante.setEndereco(dadosAtualizados.getEndereco());
        restaurante.setTelefone(dadosAtualizados.getTelefone());

        return restauranteRepository.save(restaurante);

    }

    public void deletarRestaurante(Long id) {

        if (restauranteRepository.existsById(id)) {
            restauranteRepository.deleteById(id);

        } else {
            throw new EntityNotFoundException("Esse Restaurante não existe");
        }

    }

}
