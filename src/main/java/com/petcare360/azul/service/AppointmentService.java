package com.petcare360.azul.service;



import com.petcare360.azul.model.Cita;
import com.petcare360.azul.model.Mascota;
import com.petcare360.azul.model.Servicio;
import com.petcare360.azul.model.Veterinario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Cita agendar(Mascota mascota, Veterinario veterinario, Servicio servicio, LocalDateTime fechaHora, String motivo);
    Optional<Cita> obtener(Long id);
    void cancelar(Long id);
    List<Cita> listarPorVeterinario(Long vetId);
    List<Cita> listarPorMascota(Long mascotaId);
}

