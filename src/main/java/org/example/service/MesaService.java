package org.example.service;

import org.example.model.Mesa;
import org.example.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;


    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id);
    }
    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }
}