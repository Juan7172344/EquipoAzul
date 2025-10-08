package com.petcare360.azul.service;



import com.petcare360.azul.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentValidationService {
    private final CitaRepository citaRepository;

    public AppointmentValidationService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }


    public void validarNoDuplicidadVeterinario(Long veterinarioId, LocalDateTime fechaHora) {
        boolean conflict = citaRepository.findByVeterinarioId(veterinarioId).stream()
                .anyMatch(c -> c.getFechaHora() != null && c.getFechaHora().equals(fechaHora));
        if (conflict) {
            throw new IllegalStateException("Veterinario ya tiene una cita en esa fecha/hora");
        }
    }
}
