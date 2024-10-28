package org.example.service;

import org.example.model.Reserva;
import org.example.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findReservasWithFilter(String nombre, LocalDateTime tiempoYHora, Integer numeroDePersonas) {
        Reserva reservaExample = new Reserva();
        reservaExample.setNombre(nombre);
        reservaExample.setTiempoYHora(tiempoYHora);
        reservaExample.setNumeroDePersonas(numeroDePersonas);

        Example<Reserva> example = Example.of(reservaExample);
        return reservaRepository.findAll(example);
    }

    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }
    public Reserva saveReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
    public Reserva updateReserva(Long id, Reserva reservaDetails) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            Reserva reserva = optionalReserva.get();
            reserva.setNombre(reservaDetails.getNombre());
            reserva.setTiempoYHora(reservaDetails.getTiempoYHora());
            reserva.setNumeroDePersonas(reservaDetails.getNumeroDePersonas());
            reserva.setActiva(reservaDetails.getActiva());
            return reservaRepository.save(reserva);
        } else {
            return null;
        }
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}