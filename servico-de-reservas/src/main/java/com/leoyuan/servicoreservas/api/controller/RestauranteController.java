package com.leoyuan.servicoreservas.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoyuan.servicoreservas.api.dto.input.RestauranteInput;
import com.leoyuan.servicoreservas.domain.model.Restaurante;
import com.leoyuan.servicoreservas.domain.service.RestauranteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/listar")
    public List<Restaurante> listarRestaurantes() {
        return restauranteService.listarRestaurantes();
    }

    @GetMapping("/id")
    public Optional<Restaurante> listarRestaurantePorId(@PathVariable Long id) {
        return restauranteService.buscarRestaurantePorId(id);

    }

    @PostMapping("/criar")
    public Restaurante criarRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteService.salvarRestaurante(restaurante);
    }

    @PutMapping("/{id}")
    public Restaurante atualizarRestaurante(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return restauranteService.atualizarDadosDoRestaurante(id, restaurante);
    }

    @DeleteMapping("/{id}")
    public void deletarRestaurante(@PathVariable Long id) {
        restauranteService.deletarRestaurante(id);
    }

}
