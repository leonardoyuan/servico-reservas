package com.leoyuan.servicoreservas.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leoyuan.servicoreservas.api.dto.input.ReservaInput;
import com.leoyuan.servicoreservas.api.dto.output.ReservaOutput;
import com.leoyuan.servicoreservas.domain.service.ReservaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/listar")
    public List<ReservaOutput> listarReservas() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public Optional<ReservaOutput> listarReservaPorId(@PathVariable Long id) {
        return reservaService.buscarReservaPorId(id);
    }

    @PostMapping("/criar")
    public ReservaOutput criarReserva(@RequestBody ReservaInput reservaInput) {
        return reservaService.salvarReserva(reservaInput);
    }

    @PutMapping("/{id}")
    public ReservaOutput atualizarReserva(@PathVariable Long id, @RequestBody ReservaInput reservaInput) {
        return reservaService.atualizarReserva(id, reservaInput);
    }

    @DeleteMapping("/{id}")
    public void deletarReserva(@PathVariable Long id) {
        reservaService.deletarReserva(id);
    }

}
