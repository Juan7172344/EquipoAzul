package com.petcare360.azul.repository;

import com.petcare360.azul.model.Cita;
import java.util.List;
import java.util.Optional;

public interface CitaRepository {
    Cita save(Cita cita);
    Optional<Cita> findById(Long id);
    void deleteById(Long id);
    List<Cita> findAll();
    List<Cita> findByVeterinarioId(Long veterinarioId);
    List<Cita> findByMascotaId(Long mascotaId);
}
