package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.Reserva;
import org.example.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/reservas")
    @Validated
    public class ReservaController {

        @Autowired
        private ReservaService reservaService;

        @GetMapping
        public ResponseEntity<List<Reserva>> findReservaWithFilter(@RequestParam(required = false)  String nombre,@RequestParam(required = false)  LocalDateTime tiempoYHora,@RequestParam(required = false)  Integer numeroDePersonas ) {
            return ResponseEntity.ok(reservaService.findReservasWithFilter(nombre,tiempoYHora,numeroDePersonas));
        }
        @GetMapping("/{id}")
        public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
            Optional<Reserva> reserva = reservaService.getReservaById(id);
            return reserva.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
// MAppear de una forma más bonita.
        @PostMapping
        public ResponseEntity<Reserva> createReserva(@Valid @RequestBody Reserva reserva) {
            return ResponseEntity.ok(reservaService.saveReserva(reserva));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reservaDetails) {
            Reserva updatedReserva = reservaService.updateReserva(id, reservaDetails);
            if (updatedReserva != null) {
                return ResponseEntity.ok(updatedReserva);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
            reservaService.deleteReserva(id);
            return ResponseEntity.noContent().build();
        }
    }
