package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.Mesa;
import org.example.model.Reserva;
import org.example.service.MesaService;
import org.example.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mesas")
@Validated
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable Long id) {
        Optional<Mesa> mesa = mesaService.getMesaById(id);
        return mesa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Mesa>> getAllMesas() {
        List<Mesa> mesas = mesaService.getAllMesas();
        return ResponseEntity.ok(mesas);
    }


}
